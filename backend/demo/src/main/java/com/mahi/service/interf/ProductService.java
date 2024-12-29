package com.mahi.service.interf;

import java.io.IOException;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;

import com.mahi.dto.Response;

public interface ProductService {

    Response createProduct(Long categoryId, MultipartFile image, String name, String description, BigDecimal price) throws IOException;

	Response getProductById(Long productId);

	Response getAllProducts();

	Response getProductsByCategory(Long categoryId);

	Response searchProduct(String searchValue);

}
