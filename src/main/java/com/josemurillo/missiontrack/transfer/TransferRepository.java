package com.josemurillo.missiontrack.transfer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository
        extends JpaRepository<Transfer, Long> {

    List<Transfer> findByAsset_IdOrderByTransferDateAsc(Long assetId);

}
