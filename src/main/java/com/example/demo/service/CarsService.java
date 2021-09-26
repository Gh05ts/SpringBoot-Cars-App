package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarsDao;
import com.example.demo.model.Cars;

@Service
public class CarsService {
	
	@Autowired
	private CarsDao dao;

//	public List<Cars> findCarByBrand(String brand) {
//		return dao.findCarsByBrand(brand));
//	}
	
//	public Optional<List<Cars>> priceQuery(String value) {
//		return 
//	}
}
