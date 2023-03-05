package com.gi.dao;

import java.util.List;

import com.gi.model.Cart;
import com.gi.model.Product;

public interface ProductDAO {
	boolean insertProduct(Product product);
	boolean deleteProductById(int id);
	boolean updateProductById(Product product);
	List<Product> getAllProducts();
	Product getProductById(int id);
	List<Product> getAllProductsByCat(String cat);
	List<Product> getAllProductByLowPrice(float price);
	List<Product> getAllProductByHighPrice(float price);
	List<Product> getAllProductByBetweenPrice(float pricelow,float pricehigh);
}
