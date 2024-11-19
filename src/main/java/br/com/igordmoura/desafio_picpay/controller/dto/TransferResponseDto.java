package br.com.igordmoura.desafio_picpay.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransferResponseDto(
        UUID id,
        BigDecimal value,
        Long senderId,
        String senderFullName,
        Long receiverId,
        String receiverFullName,
        LocalDateTime timestamp) {
}