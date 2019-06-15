package com.otirdamas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otirdamas.exceptions.AuthenticationException;
import com.otirdamas.exceptions.CreationException;
import com.otirdamas.model.User;
import com.otirdamas.repo.UserRepository;

@Service("authenticationService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User authenticate(User userForAuth) throws AuthenticationException {
		if(!userRepo.existsById(userForAuth.getUsername())) {
			throw new AuthenticationException("No such username exists");
		}
		List<User> users = userRepo.findByUsername(userForAuth.getUsername());
		if(1 != users.size()) {
			throw new AuthenticationException("Mulitiple records found for this username");
		}
		User retrievedUser = users.get(0);
		if(!retrievedUser.getPassword().equals(userForAuth.getPassword())) {
			throw new AuthenticationException("Password mismatch");
		}
		return retrievedUser;
	}

	@Override
	public User createUser(User userForCreation) throws CreationException {
		if(userRepo.existsById(userForCreation.getUsername())) {
			throw new CreationException("Username is already taken");
		}
		User createdUser = userRepo.save(userForCreation);
		return createdUser;
	}

}
