package br.com.igordmoura.desafio_picpay.service;

import org.springframework.stereotype.Service;

import br.com.igordmoura.desafio_picpay.Repository.WalletRepository;
import br.com.igordmoura.desafio_picpay.controller.dto.CreateWalletDto;
import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.exception.WalletDataAlreadyExistsException;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if(walletDb.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }


}
