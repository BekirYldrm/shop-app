package com.pinsoft.shopapp.controller;

import com.pinsoft.shopapp.entity.Product;
import com.pinsoft.shopapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

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
	public List<Product> getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);

	}
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam("file") MultipartFile file,
							 @RequestParam("name") String name,
							 @RequestParam("price") double price,
							 @RequestParam("explanation") String explanation,
							 @RequestParam("categoryName") String categoryName) {
		productService.addProduct(file, name, price, explanation, categoryName);
		return " Ürün ekleme başarılı";
	}


}
