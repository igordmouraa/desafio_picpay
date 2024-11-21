package br.com.igordmoura.desafio_picpay.service;

import br.com.igordmoura.desafio_picpay.controller.dto.BalanceResponseDto;
import br.com.igordmoura.desafio_picpay.controller.dto.DepositDto;
import br.com.igordmoura.desafio_picpay.exception.WalletNotFoundException;
import org.springframework.stereotype.Service;

import br.com.igordmoura.desafio_picpay.Repository.WalletRepository;
import br.com.igordmoura.desafio_picpay.controller.dto.CreateWalletDto;
import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.exception.WalletDataAlreadyExistsException;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }

    public Wallet getWalletById(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException(id));
    }

    public BalanceResponseDto getWalletBalanceMessageById(Long id) {
        Wallet wallet = getWalletById(id);
        String message = "O saldo do usuário " + wallet.getFullName() + " é " + wallet.getBalance();
        return new BalanceResponseDto(message);
    }

    @Transactional
    public Wallet deposit(DepositDto dto) {
        Wallet wallet = getWalletById(dto.getWalletId());
        wallet.credit(dto.getAmount());
        return walletRepository.save(wallet);
    }


}
