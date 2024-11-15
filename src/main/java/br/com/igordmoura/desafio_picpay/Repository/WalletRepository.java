package br.com.igordmoura.desafio_picpay.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igordmoura.desafio_picpay.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
