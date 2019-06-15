package com.otirdamas.service;

import com.otirdamas.exceptions.AuthenticationException;
import com.otirdamas.exceptions.CreationException;
import com.otirdamas.model.User;

public interface UserService {

	User authenticate(User user) throws AuthenticationException;

	User createUser(User user) throws CreationException;
	
}
