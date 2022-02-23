package com.zensar.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceDelegateImpl implements ProductServiceDelegate {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Map> getAllProducts() {
		List<Map> products = 
				this.restTemplate.getForObject("http://localhost:9001/product", List.class);
		return products;
	}

}
