package br.com.igordmoura.desafio_picpay.controller;

import br.com.igordmoura.desafio_picpay.controller.dto.TransferDto;
import br.com.igordmoura.desafio_picpay.entity.Transfer;
import br.com.igordmoura.desafio_picpay.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {

        var response = transferService.transfer(dto);

        return ResponseEntity.ok(response);
    }
}
