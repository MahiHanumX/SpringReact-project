package com.mahi.mapper;

import org.springframework.stereotype.Component;

import com.mahi.dto.CategoryDto;
import com.mahi.dto.ProductDto;
import com.mahi.entity.Category;
import com.mahi.entity.Product;

@Component
public class EntityDtoMapper {


	public CategoryDto mapCategoryToDtoBasic(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		return categoryDto;
	}

	public ProductDto mapProductToDtoBasic(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setImage(product.getImage());
		return productDto;
	}
}
