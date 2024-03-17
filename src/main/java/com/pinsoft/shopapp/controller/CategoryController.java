package com.pinsoft.shopapp.controller;

import com.pinsoft.shopapp.entity.Category;
import com.pinsoft.shopapp.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}

	@Operation(tags = "List Categories", description = "Get All Categories", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

	)})

	@GetMapping("/category")
	public List<Category> getAllCategories() {

		return categoryService.getAllCategories();

	}

	@Operation(tags = "Select Category", description = "Get Category", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

	)})

	@GetMapping("/category/{name}")
	public Category getCategory(@PathVariable String name) {

		return categoryService.getCategory(name);
	}
}
