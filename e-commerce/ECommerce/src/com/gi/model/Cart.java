package com.gi.model;

public class Cart {
	private Product product_price;
	private int quantity;

	public Product getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Product product_price) {
		this.product_price = product_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [product_price=" + product_price + ", quantity=" + quantity + "]";
	}

	public Cart(Product product_price, int quantity) {
		super();
		this.product_price = product_price;
		this.quantity = quantity;
	}

	public Cart() {
	}

}
