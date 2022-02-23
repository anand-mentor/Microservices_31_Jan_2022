package com.product.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.product.dto.Product;

@RestController
@CrossOrigin(origins="*")
public class ProductController {
	
	private static List<Product> productList = new ArrayList<Product>();
	private static int productIdCounter = 0;
	static {
		productList.add(new Product(++productIdCounter, "Chairs", 30, 1500));
		productList.add(new Product(++productIdCounter, "Tables", 15, 6000));
	}
	
	@GetMapping("/product")
	public @ResponseBody List<Product> getAllProducts() {
		return productList;
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable(value="id") String productId) {
		List<Product> filteredProductList = productList.stream().filter((product)->product.getId()==Integer.parseInt(productId)).collect(Collectors.toList());
		if(filteredProductList == null || filteredProductList.size() == 0) {
			return null;
		}
		else {
			return filteredProductList.get(0);
		}
	}

	@PostMapping(value="/product", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product createNewProduct(@RequestBody Product product) {
		product.setId(++productIdCounter);
		productList.add(product);
		System.out.println("createNewProduct(): " + product);
		return product;
	}

	@PutMapping(value="/product/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product updateProduct(@RequestBody Product newProduct, @PathVariable(value="id") String productId) {
		Product productToBeUpdated = null;
		List<Product> filteredProductList = productList.stream().filter((product)->product.getId()==Integer.parseInt(productId)).collect(Collectors.toList());
		if(filteredProductList == null || filteredProductList.size() == 0) {
			return null;
		}
		else {
			productToBeUpdated = filteredProductList.get(0);
		}
		productToBeUpdated.setName(newProduct.getName());
		productToBeUpdated.setPrice(newProduct.getPrice());
		productToBeUpdated.setQuantity(newProduct.getQuantity());
		return productToBeUpdated;
	}

	@DeleteMapping(value="/product/{id}")
	public boolean deleteProduct(@PathVariable(value="id") String productId) {
		List<Product> filteredProductList = productList.stream().filter((product)->product.getId()==Integer.parseInt(productId)).collect(Collectors.toList());
		if(filteredProductList == null || filteredProductList.size() == 0) {
			return false;
		}
		else {
			productList.remove(filteredProductList.get(0));
			return true;
		}
	}

}
