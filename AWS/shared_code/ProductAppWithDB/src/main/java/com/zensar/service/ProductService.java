package com.zensar.service;

import java.util.List;

import com.zensar.dto.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductById(int productId);
	Product createNewProduct(Product product);
	Product updateProduct(Product newProduct, int productId);
	boolean deleteProduct(int productId);
	
}
