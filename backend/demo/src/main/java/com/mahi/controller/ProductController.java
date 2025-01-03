package com.mahi.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahi.dto.Response;
import com.mahi.exception.InvalidCredentialsException;
import com.mahi.service.interf.ProductService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<Response> createProduct(@RequestParam Long categoryId, @RequestParam MultipartFile image,
			@RequestParam String name, @RequestParam String description, @RequestParam BigDecimal price) {
		if (categoryId == null || image.isEmpty() || name.isEmpty() || description.isEmpty() || price == null) {
			throw new InvalidCredentialsException("All Fields are Required");
		}
		try {
			
			productService.createProduct(categoryId, image, name, description, price);
			return new ResponseEntity<Response>(HttpStatus.OK);
		} 
			catch (IOException e) {
			return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get-by-product-id/{productId}")
	public ResponseEntity<Response> getProductById(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.getProductById(productId));
	}

	@GetMapping("/get-all")
	public ResponseEntity<Response> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/get-by-category-id/{categoryId}")
	public ResponseEntity<Response> getProductsByCategory(@PathVariable Long categoryId) {
		return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
	}

	@GetMapping("/search")
	public ResponseEntity<Response> searchForProduct(@RequestParam String searchValue) {
		return ResponseEntity.ok(productService.searchProduct(searchValue));
	}

}
