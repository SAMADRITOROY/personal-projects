package com.otirdamas.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otirdamas.model.Mango;
@Repository("mangoRepository")
public interface MangoRepository extends CrudRepository<Mango, Long>{
	
	List<Mango> findAll();
	Mango findByName(String name);
	
}
