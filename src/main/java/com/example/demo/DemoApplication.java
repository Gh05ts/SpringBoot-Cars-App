package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.dao.CarsDao;
import com.example.demo.model.Cars;

@SpringBootApplication
public class DemoApplication  {

	@Autowired
	CarsDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// For Putting data in DB, can be removed	
	@PostConstruct
	void initDB() {
		dao.saveAll(
			Stream.of(
				new Cars("Maruti Suzuki", "Baleno", "2007", 20000L, 300000L, "petrol"), 
				new Cars("Honda", "Jazz", "2017", 5000L, 700000L, "diesel"),
				new Cars("Skoda", "Superb", "2019", 5000L, 1200000L, "diesel"),
				new Cars("Hyundai", "Xcent", "2020", 10000L, 400000L, "petrol"),
				new Cars("MG", "Hector", "2017", 50000L, 1107999L, "diesel"),
				new Cars("Mahindra", "XUV300", "2020", 7000L, 900000L, "petrol"),
				new Cars("Ford", "Aspire", "2013", 175000L, 600000L, "diesel"),
				new Cars("Tata", "Nexon", "2020", 500L, 900000L, "petrol"),
				new Cars("Mahindra", "XUV300", "2020", 70000L, 250000L, "petrol"),
				new Cars("Ford", "Aspire", "2013", 175000L, 600000L, "diesel"),
				new Cars("Tata", "Nexon", "2020", 50000L, 499999L, "petrol")
			)
			.collect(Collectors.toList())
		);
	}
	
}
