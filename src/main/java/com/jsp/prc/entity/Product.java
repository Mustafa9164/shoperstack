package com.jsp.prc.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//if not work change getter and setter
	private Integer productId;
	private String productName;
	private String productFeatures;
	@Column(nullable = false)
	private Double productPrice;
    @CreationTimestamp
	private LocalDate dateOfManufacture;
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductFeatures() {
		return productFeatures;
	}
	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productFeatures="
				+ productFeatures + ", productPrice=" + productPrice + ", dateOfManufacture=" + dateOfManufacture + "]";
	}
	
	

}
