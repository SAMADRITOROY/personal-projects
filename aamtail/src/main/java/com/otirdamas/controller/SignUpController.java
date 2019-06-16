package com.otirdamas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.otirdamas.exceptions.CreationException;
import com.otirdamas.model.User;
import com.otirdamas.service.UserService;

@Controller
@SessionAttributes("user")
public class SignUpController {

	@Autowired
	private UserService userServ;
	
	@GetMapping(path = "signup")
	public String fetchSignUpPage(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping(path = "signup")
	public String createUser(
			@Valid User user,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		try {
			user = userServ.createUser(user);
			model.addAttribute("user", user);
			return "redirect:/";
		}catch(CreationException ce) {
			ce.printStackTrace();
			model.addAttribute("errorString", ce.getMessage());
			return "signup";
		}
	}
	
}
