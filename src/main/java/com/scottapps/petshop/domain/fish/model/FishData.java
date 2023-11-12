package com.scottapps.petshop.domain.fish.model;

import com.scottapps.petshop.api.checkup.CheckupServiceResponse;

import java.util.List;

public class FishData {
    private List<CheckupServiceResponse> checkupServiceResponseList;

    public List<CheckupServiceResponse> getCheckupServiceResponseList() {
        return checkupServiceResponseList;
    }

    public void setCheckupServiceResponseList(List<CheckupServiceResponse> checkupServiceResponseList) {
        this.checkupServiceResponseList = checkupServiceResponseList;
    }
}
