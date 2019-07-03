package com.otirdamas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.otirdamas.model.Cart;
import com.otirdamas.model.Mango;
import com.otirdamas.model.OrderItem;
import com.otirdamas.model.User;
import com.otirdamas.service.MangoService;

@Controller
@SessionAttributes("cart")
public class MangoDetailsController {

	@Autowired
	private MangoService mangoServ;
	private Mango mango;
	
	@GetMapping("/mangoes/{mangoName}")
	public String fetchMangoDetailsPage(
			@PathVariable String mangoName,
			Model model,
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(null != user) {
			if(null == session.getAttribute("cart")) {
				Cart cart = new Cart();
				cart.setUser(user);
				model.addAttribute("cart", cart);
			}
			mango = mangoServ.findMangoByName(mangoName);
			model.addAttribute("mango", mango);
			OrderItem orderItem = new OrderItem();
			model.addAttribute("orderItem", orderItem);
			return "mangoDetails";
		}else {
			return "redirect:/login";
		}
	} 
	
	@PostMapping("/mangoes/{mangoName}/addToCart")
	public String addToCart(
			@ModelAttribute("orderItem") OrderItem orderItem,
			@SessionAttribute("cart") Cart cart) {
		orderItem.setCart(cart);
		orderItem.setMango(mango);
		cart.getItems().add(orderItem);
		return "redirect:/cart";
	}
	
}
