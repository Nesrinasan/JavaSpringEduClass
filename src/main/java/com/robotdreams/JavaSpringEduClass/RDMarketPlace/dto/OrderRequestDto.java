package com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto;

import java.util.List;

public class OrderRequestDto {

    private List<Long> productIdList;

    private String orderDescription;

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

}
