package br.com.igordmoura.desafio_picpay.controller;

import br.com.igordmoura.desafio_picpay.controller.dto.TransferDto;
import br.com.igordmoura.desafio_picpay.controller.dto.TransferResponseDto;
import br.com.igordmoura.desafio_picpay.entity.Transfer;
import br.com.igordmoura.desafio_picpay.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/wallets/{id}/transfers")
    public ResponseEntity<List<TransferResponseDto>> getTransferHistory(@PathVariable Long id) {
        List<TransferResponseDto> transfers = transferService.getTransferHistory(id);
        return ResponseEntity.ok(transfers);
    }
}
