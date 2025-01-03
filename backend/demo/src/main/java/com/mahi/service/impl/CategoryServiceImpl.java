package com.mahi.service.impl;

import java.util.List;



import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mahi.dto.CategoryDto;
import com.mahi.dto.Response;
import com.mahi.entity.Category;
import com.mahi.exception.NotFoundException;
import com.mahi.mapper.EntityDtoMapper;
import com.mahi.repository.CategoryRepo;
import com.mahi.service.interf.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;
	private final EntityDtoMapper entityDtoMapper;

	 @Override
	 public Response createCategory(CategoryDto categoryRequest) {
	 Category category = new Category();
	 category.setName(categoryRequest.getName());
	 categoryRepo.save(category);
	 return Response.builder()
	 .status(200)
	 .message("Category created successfully")
	 .build();
	 }

	

	@Override
	public Response getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoryDtoList = categories.
				stream().
				map(entityDtoMapper::mapCategoryToDtoBasic)
				.collect(Collectors.toList());

		return Response.
				builder().
				status(200).
				categoryList(categoryDtoList).
				build();
	}

	@Override
	public Response getCategoryById(Long categoryId) {
		
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new NotFoundException("Category Not Found"));
		CategoryDto categoryDto = entityDtoMapper.mapCategoryToDtoBasic(category);
		return Response.builder().status(200).category(categoryDto).build();
	}

	
}
