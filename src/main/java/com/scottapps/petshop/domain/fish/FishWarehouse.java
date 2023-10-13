package com.scottapps.petshop.domain.fish;

import com.scottapps.petshop.externservice.checkup.CheckupServiceResponse;

import java.util.List;

public class FishWarehouse {
    private List<CheckupServiceResponse> checkupServiceResponseList;

    public List<CheckupServiceResponse> getCheckupServiceResponseList() {
        return checkupServiceResponseList;
    }

    public void setCheckupServiceResponseList(List<CheckupServiceResponse> checkupServiceResponseList) {
        this.checkupServiceResponseList = checkupServiceResponseList;
    }
}
