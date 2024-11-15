package br.com.igordmoura.desafio_picpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.service.WalletService;
import jakarta.validation.Valid;
import br.com.igordmoura.desafio_picpay.controller.dto.CreateWalletDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto) {
        Wallet wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);
    }
}
