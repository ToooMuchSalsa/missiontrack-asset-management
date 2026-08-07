package com.josemurillo.missiontrack.transfer;

import com.josemurillo.missiontrack.transfer.dto.CreateTransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(@RequestBody CreateTransferRequest request) {
        Optional <Transfer> createTransfer = transferService.createTransfer(
                request.getAssetId(),
                request.getNewLocationId(),
                request.getTransferredBy(),
                request.getReason()
        );

        if (createTransfer.isPresent()) {
            return ResponseEntity.ok(createTransfer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
