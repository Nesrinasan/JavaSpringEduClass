package com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String orderNumber;

	private Date orderDate;
	private String orderDescription;
	private Double totalAmount;
	//@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts = new HashSet<>();

//
//	@ManyToMany
//	@JoinTable(
//			name = "Order_Product",
//			joinColumns = { @JoinColumn(name = "order_id") }, //order_product tablosunda görünecek isim.
//			inverseJoinColumns = { @JoinColumn(name = "product_id") } // order_product tablosundaki product'un alanı.
//	)
//	private Set<Product> products;


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

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
}
