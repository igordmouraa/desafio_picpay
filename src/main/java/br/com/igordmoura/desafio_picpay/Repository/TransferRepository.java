package br.com.igordmoura.desafio_picpay.Repository;

import br.com.igordmoura.desafio_picpay.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID>{
    List<Transfer> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}
