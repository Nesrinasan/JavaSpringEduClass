package com.robotdreams.JavaSpringEduClass.FourthDay.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String orderNumber;

	private Date orderDate;
	private Double totalAmount;

	@ManyToMany
	@JoinTable(
			name = "Order_Product",
			joinColumns = { @JoinColumn(name = "order_id") }, //order_product tablosunda görünecek isim.
			inverseJoinColumns = { @JoinColumn(name = "product_id") } // order_product tablosundaki product'un alanı.
	)
	private Set<Product> products;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
