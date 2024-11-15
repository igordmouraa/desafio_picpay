package br.com.igordmoura.desafio_picpay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_wallet_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    @Getter
    @AllArgsConstructor
    public enum Enum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private final Long id;
        private final String description;

        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
