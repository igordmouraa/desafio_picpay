package br.com.igordmoura.desafio_picpay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igordmoura.desafio_picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long>{

}
