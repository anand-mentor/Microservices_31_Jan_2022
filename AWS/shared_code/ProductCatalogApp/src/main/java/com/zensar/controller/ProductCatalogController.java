package com.zensar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.service.ProductServiceDelegate;

@RestController
public class ProductCatalogController {

	@Autowired
	ProductServiceDelegate productServiceDelegate;
	
	@GetMapping("/product")
	public @ResponseBody List<Map> getAllProducts() {
		return productServiceDelegate.getAllProducts();
	}
}
