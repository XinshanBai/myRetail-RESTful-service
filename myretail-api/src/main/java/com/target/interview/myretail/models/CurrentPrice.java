package com.target.interview.myretail.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentPrice {

	private BigDecimal value;
	@JsonProperty("currency_code")
	private String currencyCode;

	public CurrentPrice() {
	}

	public CurrentPrice(BigDecimal value, String currencyCode) {
		this.value = value;
		this.currencyCode = currencyCode;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
