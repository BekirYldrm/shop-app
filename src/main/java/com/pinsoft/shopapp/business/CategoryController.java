package com.pinsoft.shopapp.business;

import com.pinsoft.shopapp.entity.Category;
import com.pinsoft.shopapp.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@Operation(tags = "List Categories", description = "Get All Categories", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

			) })

	@GetMapping("/category")
	public List<Category> getAllCategories() {

		return repository.findAll();

	}
	
	@Operation(tags = "Select Category", description = "Get Category", responses = {
			@ApiResponse(description = "Success", responseCode = "200"

			), @ApiResponse(description = "Data Not Found", responseCode = "404"

			) })

	@GetMapping("/category/{name}")
	public Category getCategory(@PathVariable String name) {

		var category = repository.findByName(name);

		if (category.isEmpty()) {
			throw new RuntimeException("Category not found with name:" + name);
		} else {
			return category.get();
		}

	}

}
