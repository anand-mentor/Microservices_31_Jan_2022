package com.zensar.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Product;
import com.zensar.service.ProductService;

@RestController
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public @ResponseBody List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable(value="id") int productId) {
		return productService.getProductById(productId);
	}

	@PostMapping(value="/product", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product createNewProduct(@RequestBody Product product) {
		return productService.createNewProduct(product);
	}

	@PutMapping(value="/product/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product updateProduct(@RequestBody Product newProduct, @PathVariable(value="id") int productId) {
		return productService.updateProduct(newProduct, productId);
	}

	@DeleteMapping(value="/product/{id}")
	public boolean deleteProduct(@PathVariable(value="id") int productId) {
		return productService.deleteProduct(productId);
	}

}
