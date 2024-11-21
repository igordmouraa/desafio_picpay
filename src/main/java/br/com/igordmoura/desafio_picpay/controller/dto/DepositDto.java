package br.com.igordmoura.desafio_picpay.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositDto(
        @NotNull Long walletId,
        @NotNull @Positive BigDecimal amount
) {
    public Long getWalletId() {
        return walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}