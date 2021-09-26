package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Cars;

@Repository
public interface CarsDao extends JpaRepository<Cars, Long> {
	Optional<List<Cars>> findByBrand(String brand);
	@Transactional(isolation = Isolation.SERIALIZABLE)
	Optional<List<Cars>> findByPriceLessThanEqual(long price);
	Optional<List<Cars>> findByPriceGreaterThanEqual(long price);
	@Query("SELECT DISTINCT brand FROM Cars")
	Optional<List<String>> findDistinctBrands();
}
