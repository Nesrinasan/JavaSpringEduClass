package com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
@Getter
@Setter
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

	@ManyToOne(fetch = FetchType.LAZY)
	private Users users;

	//
//	@ManyToMany
//	@JoinTable(
//			name = "Order_Product",
//			joinColumns = { @JoinColumn(name = "order_id") }, //order_product tablosunda görünecek isim.
//			inverseJoinColumns = { @JoinColumn(name = "product_id") } // order_product tablosundaki product'un alanı.
//	)
//	private Set<Product> products;




	//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
}
