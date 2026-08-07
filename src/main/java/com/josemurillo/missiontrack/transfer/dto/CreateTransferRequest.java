package com.josemurillo.missiontrack.transfer.dto;

public class CreateTransferRequest {
    private Long assetId;
    private Long newLocationId;
    private String transferredBy;
    private String reason;

    public CreateTransferRequest() {
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getNewLocationId() {
        return newLocationId;
    }

    public void setNewLocationId(Long newLocationId) {
        this.newLocationId = newLocationId;
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
