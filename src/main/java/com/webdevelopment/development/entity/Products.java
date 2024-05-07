package com.webdevelopment.development.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//basic attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imagelink;
	
	//set of categories and annotations
	@ManyToMany
	@JoinTable(name = "tb_products_category", 
	joinColumns = @JoinColumn(name="Product_Id"), 
	inverseJoinColumns = @JoinColumn(name="Category_Id")) //Product_Id is Foreign key of product
	private Set<Category> categories = new HashSet<>();
	
	//Constructor
	public Products() {
		
	}

	public Products(Long id, String name, String description, double price, String imagelink) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imagelink = imagelink;
	}
		
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImagelink() {
		return imagelink;
	}

	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(id, other.id);
	}


	

}
