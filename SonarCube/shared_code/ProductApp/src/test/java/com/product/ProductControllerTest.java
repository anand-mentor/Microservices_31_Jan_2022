package com.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.product.controller.ProductController;
import com.product.dto.Product;

public class ProductControllerTest {

	@Test
	public void testAllProducts() {
		ProductController pc = new ProductController();
		List<Product> products = pc.getAllProducts();
		assertEquals(products.size(), 2);
	}
}
