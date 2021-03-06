package com.target.interview.myretail.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.interview.myretail.models.CurrentPrice;
import com.target.interview.myretail.models.ProductDetails;
import com.target.interview.myretail.models.ProductPrice;
import com.target.interview.myretail.repositories.ProductPriceRepository;

@Service
public class ProductDetailsService {

	@Autowired
	private ProductPriceRepository productPriceRepository;

	public ProductPrice createProductPrice(int id, BigDecimal value, String currencyCode) {
		CurrentPrice currentPrice = new CurrentPrice(value, currencyCode);
		return productPriceRepository.save(new ProductPrice(id, currentPrice));
	}

	public ProductPrice getProductPrice(int id) {
		return productPriceRepository.findById(id);
	}

	public ProductPrice updateProductPrice(int id, ProductDetails productDetails) {
		ProductPrice productPrice = productPriceRepository.findById(id);
		CurrentPrice currentPrice = productDetails.getCurrentPrice();
		if (productPrice == null) {
			productPrice = new ProductPrice(id, currentPrice);
		} else {
			productPrice.setCurrentPrice(currentPrice);
		}
		return productPriceRepository.save(productPrice);
	}

	public boolean deleteProductPrice(int id) {
		ProductPrice productPrice = productPriceRepository.findById(id);
		if (productPrice != null) {
			productPriceRepository.delete(productPrice);
			return true;
		}
		return false;
	}
}
