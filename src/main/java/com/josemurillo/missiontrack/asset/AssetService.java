package com.josemurillo.missiontrack.asset;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset>  getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    public Optional<Asset> updateAsset(Long id, Asset updatedAsset) {
        Optional<Asset> existingAsset = assetRepository.findById(id);

        if (existingAsset.isPresent()) {
            Asset asset = existingAsset.get();
            asset.setAssetTag(updatedAsset.getAssetTag());
            asset.setSerialNumber(updatedAsset.getSerialNumber());
            asset.setName(updatedAsset.getName());
            asset.setDescription(updatedAsset.getDescription());
            asset.setCategory(updatedAsset.getCategory());
            asset.setManufacturer(updatedAsset.getManufacturer());
            asset.setModel(updatedAsset.getModel());
            asset.setStatus(updatedAsset.getStatus());
            assetRepository.save(asset);
            return Optional.of(asset);
        } else {
            return Optional.empty();
        }
    }
}
