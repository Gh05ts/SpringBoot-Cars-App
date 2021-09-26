package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// implements Serializable 
//	@GeneratedValue(strategy = GenerationType.AUTO)

@Entity
public class Cars implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String brand;
	private String model;
	private String year;
	private Long kms;
	private Long price;
	private String fuel;

	public Cars(String brand, String model, String year, Long kms, Long price, String fuel) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.kms = kms;
		this.price = price;
		this.fuel = fuel;
	}
	
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Long getKms() {
		return kms;
	}
	public void setKms(Long kms) {
		this.kms = kms;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	@Override
	public String toString() {
		return "Cars [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", kms=" + kms
				+ ", price=" + price + ", fuel=" + fuel + "]";
	}
	
}
