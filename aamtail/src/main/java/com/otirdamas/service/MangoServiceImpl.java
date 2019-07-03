package com.otirdamas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otirdamas.model.Mango;
import com.otirdamas.repo.MangoRepository;

@Service("mangoService")
public class MangoServiceImpl implements MangoService {

	@Autowired
	private MangoRepository mangoRepo;
	
	@Override
	public List<Mango> findAllMangoes() {
		return mangoRepo.findAll();
	}

	@Override
	public Mango findMangoByName(String mangoName) {
		return mangoRepo.findByName(mangoName);
	}
	
}
