package com.target.interview.myretail.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class ProductPrice {

	@Id
	private int id;
	@JsonProperty("current_price")
	private CurrentPrice currentPrice;

	public ProductPrice(int id, CurrentPrice currentPrice) {
		super();
		this.id = id;
		this.currentPrice = currentPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
}
