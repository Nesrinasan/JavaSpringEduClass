package com.robotdreams.JavaSpringEduClass.FourthDay.dto;

import lombok.Data;


public class OrderInfoResponseDto {

	private String orderNumber;
	private Double totalAmount;


	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
