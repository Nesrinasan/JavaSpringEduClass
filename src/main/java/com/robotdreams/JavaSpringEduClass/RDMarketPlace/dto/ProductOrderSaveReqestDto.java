package com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto;

public class ProductOrderSaveReqestDto {

    private Long productId;
    private String orderDescription;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
