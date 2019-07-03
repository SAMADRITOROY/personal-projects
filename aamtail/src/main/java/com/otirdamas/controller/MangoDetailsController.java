package com.otirdamas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.otirdamas.model.Cart;
import com.otirdamas.model.Mango;
import com.otirdamas.model.OrderItem;
import com.otirdamas.model.User;
import com.otirdamas.service.MangoService;

@Controller
@SessionAttributes({"cart", "lastViewedMango"})
public class MangoDetailsController {

	@Autowired
	private MangoService mangoServ;
	
	@GetMapping("/mangoes/{mangoName}")
	public String fetchMangoDetailsPage(
			@PathVariable String mangoName,
			@SessionAttribute("user") User user,
			Model model,
			HttpSession session) {
		
		if(null == session.getAttribute("cart")) {
			Cart cart = new Cart();
			cart.setUser(user);
			model.addAttribute("cart", cart);
		}
		
		Mango mango = mangoServ.findMangoByName(mangoName);
		model.addAttribute("mango", mango);
		model.addAttribute("lastViewedMango", mango);
		
		OrderItem orderItem = new OrderItem();
		model.addAttribute("orderItem", orderItem);
		
		return "mangoDetails";
	} 
	
}
