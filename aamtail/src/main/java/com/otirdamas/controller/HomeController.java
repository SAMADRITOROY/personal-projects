package com.otirdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.otirdamas.service.MangoService;

@Controller
public class HomeController {
	
	@Autowired
	private MangoService mangoServ;
	
	@GetMapping(path="/")
	public String fetchHomePage(Model model) {
		model.addAttribute("mangoList", mangoServ.findAllMangoes());
		return "home";
	}
	
}
