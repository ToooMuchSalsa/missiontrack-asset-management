package com.josemurillo.missiontrack.asset;

import com.josemurillo.missiontrack.asset.dto.UpdateAssetStatusRequest;
import com.josemurillo.missiontrack.transfer.dto.TransferHistoryResponse;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

import com.josemurillo.missiontrack.transfer.Transfer;
import com.josemurillo.missiontrack.transfer.TransferService;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService assetService;

    private final TransferService transferService;

    public AssetController(
            AssetService assetService,
            TransferService transferService) {
        this.assetService = assetService;
        this.transferService = transferService;
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        Optional<Asset> asset = assetService.getAssetById(id);

        if (asset.isPresent()) {
            return ResponseEntity.ok(asset.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset) {
        Optional<Asset> asset = assetService.updateAsset(id, updatedAsset);

        if (asset.isPresent()) {
            return ResponseEntity.ok(asset.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Asset> updateAssetStatus(@PathVariable Long id, @RequestBody UpdateAssetStatusRequest request) {
        Optional<Asset> asset = assetService.updateAssetStatus(id, request.getStatus());

        if (asset.isPresent()) {
            return ResponseEntity.ok(asset.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/transfers")
    public ResponseEntity<List<TransferHistoryResponse>> getTransferHistory(
            @PathVariable Long id) {
        Optional<List<TransferHistoryResponse>> transfers = transferService.getTransferHistory(id);

        if (transfers.isPresent()) {
            return ResponseEntity.ok(transfers.get());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}
