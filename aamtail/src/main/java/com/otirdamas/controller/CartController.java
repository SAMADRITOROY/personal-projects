package com.otirdamas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.otirdamas.model.Cart;
import com.otirdamas.model.Mango;
import com.otirdamas.model.OrderItem;
import com.otirdamas.model.User;
import com.otirdamas.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartServ;
	
	@GetMapping("/cart")
	public String fetchCartPage(
			@SessionAttribute("user") User user,
			Model model,
			HttpSession session) {
		Cart cart = (Cart)session.getAttribute("cart");
		if(null == cart) {
			cart = new Cart();
			cart.setUser(user);
		}
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PostMapping("/addToCart")
	public String addToCart(
			@ModelAttribute("orderItem") OrderItem orderItem,
			@SessionAttribute("lastViewedMango") Mango mango,
			@SessionAttribute("cart") Cart cart) {
		orderItem.setCart(cart);
		orderItem.setMango(mango);
		cart.getItems().add(orderItem);
		return "redirect:/";
	}
	
	@GetMapping("/buyCart")
	public String buyCart(
			@SessionAttribute("cart") Cart cart, 
			HttpSession session) {
		cartServ.buyCart(cart);
		session.removeAttribute("cart");
		return "redirect:/";
	}
	
}
