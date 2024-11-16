package br.com.igordmoura.desafio_picpay.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDto(@DecimalMin("0.1") @NotNull BigDecimal value,
                          @NotNull Long payer,
                          @NotNull Long payee) {
}
