package com.josemurillo.missiontrack.asset.dto;

public class UpdateAssetLocationRequest{
    private Long locationId;

    public UpdateAssetLocationRequest() {
    }

    public Long getLocationId() {
        return locationId;
    }
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
