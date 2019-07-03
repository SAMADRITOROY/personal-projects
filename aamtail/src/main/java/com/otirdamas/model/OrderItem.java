package com.otirdamas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@ManyToOne
	private Mango mango;
	
	@Column(name="QUANTITY")
	private float quantity;
	
	@ManyToOne
	private Cart cart;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mango getMango() {
		return mango;
	}

	public void setMango(Mango mango) {
		this.mango = mango;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
