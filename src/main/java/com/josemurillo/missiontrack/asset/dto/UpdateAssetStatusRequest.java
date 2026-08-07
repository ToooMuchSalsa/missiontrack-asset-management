package com.josemurillo.missiontrack.asset.dto;

import com.josemurillo.missiontrack.asset.AssetStatus;

public class UpdateAssetStatusRequest {
    private AssetStatus status;

    public UpdateAssetStatusRequest() {

    }

    public AssetStatus getStatus() {
        return status;
    }
    public void setStatus(AssetStatus status) {
        this.status = status;
    }
}
