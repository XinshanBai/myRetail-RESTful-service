
package com.target.interview.myretail.models.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@JsonProperty("available_to_promise_network")
	private AvailableToPromiseNetwork available_to_promise_network;
	private Item item;

	public AvailableToPromiseNetwork getAvailable_to_promise_network() {
		return available_to_promise_network;
	}

	public void setAvailable_to_promise_network(AvailableToPromiseNetwork available_to_promise_network) {
		this.available_to_promise_network = available_to_promise_network;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
