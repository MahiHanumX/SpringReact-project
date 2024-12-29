package com.mahi.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	private int status;
	private String message;
	private final LocalDateTime timestamp = LocalDateTime.now();

	

	private int totalPage;
	private long totalElement;

	private CategoryDto category;
	private List<CategoryDto> categoryList;

	private ProductDto product;
	private List<ProductDto> productList;

}
