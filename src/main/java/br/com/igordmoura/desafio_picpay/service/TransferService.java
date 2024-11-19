package br.com.igordmoura.desafio_picpay.service;

import br.com.igordmoura.desafio_picpay.Repository.TransferRepository;
import br.com.igordmoura.desafio_picpay.Repository.WalletRepository;
import br.com.igordmoura.desafio_picpay.controller.dto.TransferDto;
import br.com.igordmoura.desafio_picpay.controller.dto.TransferResponseDto;
import br.com.igordmoura.desafio_picpay.entity.Transfer;
import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.exception.InsufficientBalanceException;
import br.com.igordmoura.desafio_picpay.exception.TransferNotAllowedForWalletTypeException;
import br.com.igordmoura.desafio_picpay.exception.TransferNotAuthorizedException;
import br.com.igordmoura.desafio_picpay.exception.WalletNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository, AuthorizationService authorizationService, NotificationService notificationService, WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {

        var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));

        validateTransfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender, receiver, transferDto.value(), LocalDateTime.now());

        walletRepository.save(sender);
        walletRepository.save(receiver);

        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    public void validateTransfer(TransferDto transferDto, Wallet sender) {
        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalanceEqualOrGreaterThan(transferDto.value())) {
            throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }

    }

    public List<TransferResponseDto> getTransferHistory(Long walletId) {
        return transferRepository.findBySenderIdOrReceiverId(walletId, walletId)
                .stream()
                .map(transfer -> new TransferResponseDto(
                        transfer.getId(),
                        transfer.getValue(),
                        transfer.getSender().getId(),
                        transfer.getSender().getFullName(),
                        transfer.getReceiver().getId(),
                        transfer.getReceiver().getFullName(),
                        transfer.getTimestamp()))
                .collect(Collectors.toList());
    }
}
