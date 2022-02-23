package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

}
