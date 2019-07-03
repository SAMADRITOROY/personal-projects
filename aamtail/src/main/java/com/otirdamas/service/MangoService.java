package com.otirdamas.service;

import java.util.List;

import com.otirdamas.model.Mango;

public interface MangoService {
	List<Mango> findAllMangoes();
	Mango findMangoByName(String mangoName); 
}
