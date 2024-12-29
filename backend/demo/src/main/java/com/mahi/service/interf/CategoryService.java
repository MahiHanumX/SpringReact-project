package com.mahi.service.interf;

import com.mahi.dto.CategoryDto;
import com.mahi.dto.Response;

public interface CategoryService {

	 Response createCategory(CategoryDto categoryRequest);
	Response getAllCategories();

	Response getCategoryById(Long categoryId);
}
