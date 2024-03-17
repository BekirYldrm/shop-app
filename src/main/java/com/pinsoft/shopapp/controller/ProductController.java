package com.pinsoft.shopapp.controller;

import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

	private ProductService productService;
	public ProductController(ProductService productService){this.productService = productService;}

	@Operation(tags = "List Products", description = "Get All Products", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "Data Not Found", responseCode = "404")
		})

	@GetMapping("/product")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();

	}

	@Operation(tags = "Select Product", description = "Get Product", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "Data Not Found", responseCode = "404")
	})

	@GetMapping("/product/{name}")
	public Product getProduct(@PathVariable String name) {
		return productService.getProduct(name);

	}

}
