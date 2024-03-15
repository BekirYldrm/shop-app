package com.pinsoft.shopapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private String explanation;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@JsonBackReference
	private Category category;

	public Product() {
		super();
	}

	public Product(String name, double price, String explanation) {
		super();
		this.name = name;
		this.price = price;
		this.explanation = explanation;
		
		
	}

	public int getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}
