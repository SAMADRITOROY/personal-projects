package com.otirdamas.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otirdamas.model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{
	
	Boolean existsByUsername(String username);
	List<User> findByUsername(String username);
	
}
