package com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {

	@Column
	private String name;

	@Column
	private String category;

	private String photoUrl;

	private String description;

	private Double price;

	@OneToMany(mappedBy = "product")
	private Set<OrderProduct> orderProducts = new HashSet<>();

//	@ManyToMany(mappedBy = "products")
//	private Set<Order> orders;

	private static final long serialVersionUID = 1L;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}
}
