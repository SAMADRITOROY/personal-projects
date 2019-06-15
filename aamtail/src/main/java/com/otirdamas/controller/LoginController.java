package com.otirdamas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.otirdamas.exceptions.AuthenticationException;
import com.otirdamas.model.User;
import com.otirdamas.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private UserService userServ;

	@GetMapping(path="login")
	public String fetchLoginPage(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping(path="login")
	public String performLogin(@ModelAttribute("user") User user,
			Model model) {
		try {
			model.addAttribute("user", userServ.authenticate(user));
			return "redirect:/";
		}catch(AuthenticationException authEx) {
			authEx.printStackTrace();
			model.addAttribute("errorString", authEx.getMessage());
			return "login";
		}
	}
	
}
