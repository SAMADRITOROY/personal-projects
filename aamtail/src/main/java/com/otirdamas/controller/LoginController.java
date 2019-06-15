package com.otirdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otirdamas.exceptions.AuthenticationException;
import com.otirdamas.model.User;
import com.otirdamas.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userServ;

	@GetMapping(path="login")
	public ModelAndView fetchLoginPage() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@PostMapping(path="login")
	public ModelAndView performLogin(User userForAuth) {
		ModelAndView mv = new ModelAndView();
		try {
			User retrievedUser = userServ.authenticate(userForAuth);
			mv.setViewName("home");
			mv.addObject("user", retrievedUser);
		}catch(AuthenticationException authEx) {
			authEx.printStackTrace();
			mv.setViewName("login");
			mv.addObject("errorString", authEx.getMessage());
		}
		return mv;
	}
	
}
