package com.josemurillo.missiontrack.transfer;

import com.josemurillo.missiontrack.exception.InvalidTransferException;
import com.josemurillo.missiontrack.asset.Asset;
import com.josemurillo.missiontrack.asset.AssetRepository;
import com.josemurillo.missiontrack.location.Location;
import com.josemurillo.missiontrack.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AssetRepository assetRepository;
    private final LocationRepository locationRepository;

    public TransferService(
            TransferRepository transferRepository,
            AssetRepository assetRepository,
            LocationRepository locationRepository) {

        this.transferRepository = transferRepository;
        this.assetRepository = assetRepository;
        this.locationRepository = locationRepository;
    }

    @Transactional
    public Optional<Transfer> createTransfer(
            Long assetId,
            Long newLocationId,
            String transferredBy,
            String reason) {
        Optional<Asset> existingAsset = assetRepository.findById(assetId);
        Optional<Location> existingLocation = locationRepository.findById(newLocationId);

        if (existingAsset.isEmpty() || existingLocation.isEmpty()) {
            return Optional.empty();
        }

        Asset asset = existingAsset.get();
        Location newLocation = existingLocation.get();

        Location previousLocation = asset.getCurrentLocation();

        // Business rule:
        // Do not allow a transfer to the asset's current location.
        if (previousLocation != null &&
                previousLocation.getId().equals(newLocation.getId())) {

            throw new InvalidTransferException(
                    "Asset is already at this location"
            );
        }

        Transfer transfer = new Transfer();
        transfer.setAsset(asset);
        transfer.setPreviousLocation(previousLocation);
        transfer.setNewLocation(newLocation);
        transfer.setTransferDate(LocalDateTime.now());
        transfer.setTransferredBy(transferredBy);
        transfer.setReason(reason);

        asset.setCurrentLocation(newLocation);
        assetRepository.save(asset);

        Transfer savedTransfer = transferRepository.save(transfer);

        return Optional.of(savedTransfer);
    }


}
