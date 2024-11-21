package br.com.igordmoura.desafio_picpay.controller;

import br.com.igordmoura.desafio_picpay.controller.dto.BalanceResponseDto;
import br.com.igordmoura.desafio_picpay.controller.dto.DepositDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.service.WalletService;
import jakarta.validation.Valid;
import br.com.igordmoura.desafio_picpay.controller.dto.CreateWalletDto;

import java.math.BigDecimal;

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

    @GetMapping("/wallets/{id}/balance")
    public ResponseEntity<BalanceResponseDto> getWalletBalanceById(@PathVariable @NotNull Long id) {
        BalanceResponseDto balanceResponse = walletService.getWalletBalanceMessageById(id);
        return ResponseEntity.ok(balanceResponse);
    }

    @PostMapping("/wallets/deposit")
    public ResponseEntity<Wallet> deposit(@RequestBody @Valid DepositDto depositDto) {
        Wallet updatedWallet = walletService.deposit(depositDto);
        return ResponseEntity.ok(updatedWallet);
    }

}
