package com.robotdreams.JavaSpringEduClass.immutable;

public final class OrderRequestDto {

    private final int price;

    public OrderRequestDto(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
