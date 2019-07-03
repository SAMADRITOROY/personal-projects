package com.otirdamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otirdamas.model.Cart;
import com.otirdamas.repo.CartRepository;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	public void buyCart(Cart cart) {
		cartRepo.save(cart);
	}
	
}
