package com.robotdreams.JavaSpringEduClass.FourthDay.dto;

public class OrderRequestDto {

    private long productId;
    private String orderDescription;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
