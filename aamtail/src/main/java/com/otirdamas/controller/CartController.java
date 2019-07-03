package com.otirdamas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.otirdamas.model.Cart;
import com.otirdamas.model.User;
import com.otirdamas.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartServ;
	
	@GetMapping("/cart")
	public String fetchCartPage(
			Model model,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(null != user) {
			Cart cart = (Cart)session.getAttribute("cart");
			if(null == cart) {
				cart = new Cart();
				cart.setUser(user);
			}
			model.addAttribute("cart", cart);
			return "cart";
		}else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/cart/buyCart")
	public String buyCart(
			@SessionAttribute("cart") Cart cart, 
			HttpSession session) {
		cartServ.buyCart(cart);
		session.removeAttribute("cart");
		return "redirect:/cart";
	}
	
}
