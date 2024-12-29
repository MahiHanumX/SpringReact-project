package com.mahi.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.dto.CategoryDto;
import com.mahi.dto.Response;
import com.mahi.service.interf.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	@PostMapping("/create")
	public ResponseEntity<Response> createCategory(@RequestBody CategoryDto
	categoryDto){
	return ResponseEntity.ok(categoryService.createCategory(categoryDto));
	}

	@GetMapping("/get-all")
	public ResponseEntity<Response> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}



	@GetMapping("/get-category-by-id/{categoryId}")
	public ResponseEntity<Response> getCategoryById(@PathVariable Long categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

}
