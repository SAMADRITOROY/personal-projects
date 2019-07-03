package com.otirdamas.repo;

import org.springframework.data.repository.CrudRepository;

import com.otirdamas.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{
	
}
