package com.mybootproject.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(nullable = false)
private String name;

@Column(nullable = false)
private String city;

@Column(nullable = false)
private String age;

public Customer(Long id, String name, String city, String age) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.age = age;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

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

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + "]";
}

}