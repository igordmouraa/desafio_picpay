package br.com.igordmoura.desafio_picpay.controller.dto;

import br.com.igordmoura.desafio_picpay.entity.Wallet;
import br.com.igordmoura.desafio_picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String fullName, @NotBlank String cpfCnpj, @NotBlank String email, @NotBlank String password,
        @NotNull WalletType.Enum walletType) {

    public Wallet toWallet() {
        WalletType walletTypeEntity = walletType.get();

        return Wallet.builder()
                .fullName(fullName)
                .cpfCnpj(cpfCnpj)
                .email(email)
                .password(password)
                .walletType(walletTypeEntity)
                .build();
    }
}
