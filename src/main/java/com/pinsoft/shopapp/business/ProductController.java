package com.pinsoft.shopapp.business;

import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
	@Autowired
	private  ProductRepository repository;

	@Operation(tags = "List Products", description = "Get All Products", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

			) })
	@GetMapping("/product")
	public List<Product> getAllProducts() {

		return repository.findAll();

	}

	@Operation(tags = "Select Product", description = "Get Product", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

			) })
	@GetMapping("/product/{name}")
	public Product getProduct(@PathVariable String name) {

		var category = repository.findByName(name);

		if (category.isEmpty()) {
			throw new RuntimeException("Product not found with name:" + name);
		} else {
			return category.get();
		}

	}

}
