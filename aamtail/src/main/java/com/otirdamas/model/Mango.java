package com.otirdamas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mango {

	@Id
	private String name;
	private String region;
	private float price;
	
	public Mango() {
		this(null, null, 0);
	}

	public Mango(String name, String region, float price) {
		super();
		this.name = name;
		this.region = region;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}	
	
}
