package br.com.igordmoura.desafio_picpay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_tranfer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Transfer(Wallet sender, Wallet receiver, BigDecimal value, LocalDateTime timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
        this.timestamp = timestamp;
    }
}