package com.gi.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email; 
	private String password;
	private String city;
	private long mobile;
	private List<Cart> carts = new ArrayList<>();
	
	public boolean addToCart(Cart cart)
	{
		return carts.add(cart);
	}
	
	public List<Cart> getCarts() {
		return carts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ ", mobile=" + mobile + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public User(String name, String email, String password, String city, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.mobile = mobile;
	}
	public User() {
		super();
	}
}
