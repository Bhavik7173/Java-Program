package com.gi.model;

public class Product {
	private int id;
	private String name;
	private String desc;
	private float price;
	private String cat;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", cat=" + cat + "]";
	}
	public Product(String name, String desc, float price, String cat) {
		super();		
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.cat = cat;
	}
	public Product() {
		super();
	}
}
