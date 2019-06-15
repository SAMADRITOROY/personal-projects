package com.otirdamas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.otirdamas.exceptions.AuthenticationException;
import com.otirdamas.model.User;
import com.otirdamas.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userServ;

	@RequestMapping(path="login", method=RequestMethod.GET)
	public ModelAndView fetchLoginPage() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public ModelAndView performLogin(User userForAuth, HttpServletRequest request) {
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
