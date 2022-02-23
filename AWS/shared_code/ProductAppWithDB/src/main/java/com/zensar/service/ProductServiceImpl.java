package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Product;
import com.zensar.entity.ProductEntity;
import com.zensar.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		List<ProductEntity> productEntityList = productRepo.findAll();
		List<Product> productList = new ArrayList<>();
		for(ProductEntity productEntity: productEntityList) {
			productList.add(new Product(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getPrice()));
		}
		return productList;
	}

	@Override
	public Product getProductById(int productId) {
		Optional<ProductEntity> opProductEntity = productRepo.findById((long)productId);
		if(opProductEntity.isPresent()) {
			ProductEntity productEntity = opProductEntity.get();
			return new Product(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getPrice());
		}
		return null;
	}

	@Override
	public Product createNewProduct(Product product) {
		ProductEntity productEntity = productRepo.save(new ProductEntity(product.getId(), product.getName(), product.getQuantity(), product.getPrice()));
		return new Product(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getPrice());
	}

	@Override
	public Product updateProduct(Product newProduct, int productId) {
		Optional<ProductEntity> opProductEntity = productRepo.findById((long)productId);
		if(opProductEntity.isPresent()) {
			ProductEntity productEntity = opProductEntity.get();
			productEntity.setName(newProduct.getName());
			productEntity.setQuantity(newProduct.getQuantity());
			productEntity.setPrice(newProduct.getPrice());
			return new Product(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getPrice());
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int productId) {
		productRepo.deleteById((long)productId);
		return true;
	}

}
