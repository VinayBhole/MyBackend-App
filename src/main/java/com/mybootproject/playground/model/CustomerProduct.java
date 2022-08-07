package com.mybootproject.playground.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_product")
public class CustomerProduct {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private LocalDate dateOfPurchase;

private Boolean couponUsed;

private String couponCode;

@OneToOne
private Product product;

@OneToOne
private Customer customer;

@Override
public String toString() {
	return "CustomerProduct [id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", couponUsed=" + couponUsed
			+ ", couponCode=" + couponCode + ", product=" + product + ", customer=" + customer + "]";
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public LocalDate getDateOfPurchase() {
	return dateOfPurchase;
}

public void setDateOfPurchase(LocalDate dateOfPurchase) {
	this.dateOfPurchase = dateOfPurchase;
}

public Boolean getCouponUsed() {
	return couponUsed;
}

public void setCouponUsed(Boolean couponUsed) {
	this.couponUsed = couponUsed;
}

public String getCouponCode() {
	return couponCode;
}

public void setCouponCode(String couponCode) {
	this.couponCode = couponCode;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public CustomerProduct(Long id, LocalDate dateOfPurchase, Boolean couponUsed, String couponCode, Product product,
		Customer customer) {
	super();
	this.id = id;
	this.dateOfPurchase = dateOfPurchase;
	this.couponUsed = couponUsed;
	this.couponCode = couponCode;
	this.product = product;
	this.customer = customer;
}

public CustomerProduct() {
	super();
	// TODO Auto-generated constructor stub
}

}