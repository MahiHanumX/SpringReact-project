package com.mahi.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


import java.util.stream.Collectors;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahi.dto.ProductDto;
import com.mahi.dto.Response;
import com.mahi.entity.Category;
import com.mahi.entity.Product;
import com.mahi.exception.*;
import com.mahi.mapper.EntityDtoMapper;
import com.mahi.repository.CategoryRepo;
import com.mahi.repository.ProductRepo;
import com.mahi.service.interf.ProductService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final EntityDtoMapper entityDtoMapper;

	 @Override
	 public Response createProduct(Long categoryId, MultipartFile image, String
	 name, String description, BigDecimal price) throws IOException{
	 Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new
	 NotFoundException("Category not found"));
	 Product product = new Product();
		
	 product.setImage(image.getBytes());
	 product.setCategory(category);
	 product.setPrice(price);
	 product.setName(name);
	 product.setDescription(description);
	
	 productRepo.save(product);
	 return Response.builder()
	 .status(200)
	 .message("Product successfully created")
	 .build();
	 }

	

	@Override
	public Response getProductById(Long productId){
		
		Product product = productRepo.findById(productId).orElseThrow(() -> new NotFoundException("Product Not Found"));
		ProductDto productDto = entityDtoMapper.mapProductToDtoBasic(product);

		return Response.builder().status(200).product(productDto).build();
	}

	@Override
	public Response getAllProducts() {
		List<ProductDto> productList = productRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
				.map(entityDtoMapper::mapProductToDtoBasic).collect(Collectors.toList());

		return Response.builder().status(200).productList(productList).build();

	}

	@Override
	public Response getProductsByCategory(Long categoryId) {
		List<Product> products = productRepo.findByCategoryId(categoryId);
		if (products.isEmpty()) {
			throw new NotFoundException("Product not found");
		}
		List<ProductDto> productDtoList = products.stream().map(entityDtoMapper::mapProductToDtoBasic)
				.collect(Collectors.toList());

		return Response.builder().status(200).productList(productDtoList).build();

	}

	@Override
	public Response searchProduct(String searchValue) {
		List<Product> products = productRepo.findByNameContainingOrDescriptionContaining(searchValue, searchValue);

		if (products.isEmpty()) {
			throw new NotFoundException("product not found");
		}
		List<ProductDto> productDtoList = products.stream().map(entityDtoMapper::mapProductToDtoBasic)
				.collect(Collectors.toList());

		return Response.builder().status(200).productList(productDtoList).build();
	}
}
