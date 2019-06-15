package com.otirdamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otirdamas.exceptions.CreationException;
import com.otirdamas.model.User;
import com.otirdamas.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	private UserService userServ;
	
	@GetMapping(path = "signup")
	ModelAndView fetchSignUpPage() {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("user", new User());
		return mv;
	}
	
	@PostMapping(path = "signup")
	ModelAndView createUser(User userForCreation) {
		ModelAndView mv = new ModelAndView();
		try {
			User createdUser = userServ.createUser(userForCreation);
			mv.setViewName("home");
			mv.addObject("user", createdUser);
		}catch(CreationException ce) {
			ce.printStackTrace();
			mv.setViewName("signup");
			mv.addObject("user", userForCreation);
			mv.addObject("errorString", ce.getMessage());
		}
		return mv;
	}
	
}
