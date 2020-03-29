package com.target.interview.myretail.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.target.interview.myretail.models.ProductDetails;
import com.target.interview.myretail.models.ProductPrice;
import com.target.interview.myretail.models.internal.ProductInfo;
import com.target.interview.myretail.services.ProductDetailsService;

@RestController
@RequestMapping("/myRetail/v1")
public class ProductDetailsController {

	private static final String productInfoAPIURL = "https://redsky.target.com/v2/pdp/tcin/";
	private static final String productInfoAPIRequestParam = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	@Autowired
	private ProductDetailsService productDetailsService;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.POST, value = "/products/{id}/createPrice")
	public String createProductPrice(@PathVariable int id, @RequestBody ProductPrice productPrice) {
		productDetailsService.createProductPrice(id, productPrice.getCurrentPrice().getValue(),
				productPrice.getCurrentPrice().getCurrencyCode());
		return "Product price for Product[" + id + "] has been created.";
	}

	@RequestMapping("/products/{id}")
	public ProductDetails getProductDetails(@PathVariable int id) {
		ProductDetails productDetails = new ProductDetails();
		ProductPrice productPrice = productDetailsService.getProductPrice(id);
		ProductInfo ProductInfo = restTemplate.getForObject(productInfoAPIURL + id + productInfoAPIRequestParam,
				ProductInfo.class);
		if (ProductInfo.getProduct().getItem().getProductDescription() != null) {
			String productName = ProductInfo.getProduct().getItem().getProductDescription().getTitle();
			productDetails.setName(productName);
			productDetails.setId(id);
			productDetails.setCurrentPrice(productPrice.getCurrentPrice());
		}
		return productDetails;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public String updateProductDetails(@PathVariable int id, @RequestBody ProductDetails productDetails) {
		productDetailsService.updateProductPrice(id, productDetails);
		return "Product price for Product[" + id + "] has been updated.";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		if (productDetailsService.deleteProductPrice(id))
			return "Product price for Product[" + id + "] has been delete.";
		else
			return "Product price does not exist for Product[" + id + "].";
	}
}
