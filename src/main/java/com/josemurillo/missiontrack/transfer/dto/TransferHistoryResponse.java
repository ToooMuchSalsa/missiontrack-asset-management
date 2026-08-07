package com.josemurillo.missiontrack.transfer.dto;

import java.time.LocalDateTime;

public class TransferHistoryResponse {
    private Long id;

    private Long assetId;
    private String assetTag;

    private Long previousLocationId;
    private String previousLocationName;

    private Long newLocationId;
    private String newLocationName;

    private LocalDateTime transferDate;

    private String transferredBy;
    private String reason;

    public TransferHistoryResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Long getPreviousLocationId() {
        return previousLocationId;
    }

    public void setPreviousLocationId(Long previousLocationId) {
        this.previousLocationId = previousLocationId;
    }

    public String getPreviousLocationName() {
        return previousLocationName;
    }

    public void setPreviousLocationName(String previousLocationName) {
        this.previousLocationName = previousLocationName;
    }

    public Long getNewLocationId() {
        return newLocationId;
    }

    public void setNewLocationId(Long newLocationId) {
        this.newLocationId = newLocationId;
    }

    public String getNewLocationName() {
        return newLocationName;
    }

    public void setNewLocationName(String newLocationName) {
        this.newLocationName = newLocationName;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferredBy() {
        return transferredBy;
    }

    public void setTransferredBy(String transferredBy) {
        this.transferredBy = transferredBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
