package com.pinsoft.shopapp.repository;

import com.pinsoft.shopapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends  JpaRepository<Product, Integer> {
	
	 Optional<Product> findByName(String name);

}
