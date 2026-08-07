package com.josemurillo.missiontrack.asset;

import com.josemurillo.missiontrack.location.Location;
import com.josemurillo.missiontrack.location.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    private final LocationRepository locationRepository;

    public AssetService(AssetRepository assetRepository, LocationRepository locationRepository) {
        this.assetRepository = assetRepository;
        this.locationRepository = locationRepository;
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
            Asset savedAsset = assetRepository.save(asset);
            return Optional.of(savedAsset);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Asset> updateAssetStatus(Long id, AssetStatus status) {
        Optional<Asset> existingAsset = assetRepository.findById(id);

        if (existingAsset.isPresent()) {
            Asset asset = existingAsset.get();
            asset.setStatus(status);

            Asset savedAsset = assetRepository.save(asset);
            return Optional.of(savedAsset);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Asset> updateAssetLocation(Long id, Long locationId) {
        Optional<Asset> existingAsset = assetRepository.findById(id);
        Optional<Location> existingLocation = locationRepository.findById(locationId);

        if (existingAsset.isEmpty() || existingLocation.isEmpty()) {
            return Optional.empty();
        } else {
            Asset asset = existingAsset.get();
            Location location = existingLocation.get();

            asset.setCurrentLocation(location);

            Asset savedAsset = assetRepository.save(asset);
            return Optional.of(savedAsset);
        }
    }
}
