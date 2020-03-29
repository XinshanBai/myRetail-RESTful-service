package com.target.interview.myretail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.target.interview.myretail.models.ProductPrice;

public interface ProductPriceRepository extends MongoRepository<ProductPrice, Integer> {
	
	public ProductPrice findById(int id);
}
