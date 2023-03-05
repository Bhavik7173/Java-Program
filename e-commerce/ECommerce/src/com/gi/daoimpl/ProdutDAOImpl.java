package com.gi.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.gi.dao.ProductDAO;
import com.gi.model.Cart;
import com.gi.model.Product;

public class ProdutDAOImpl implements ProductDAO {
	private List<Product> products;
	//create cart list
	private List<Cart> cart_product;
	private static ProdutDAOImpl daoImpl = null;

	private ProdutDAOImpl() {
		products = new ArrayList<>();
		cart_product = new ArrayList<>();
	}

	public static synchronized ProdutDAOImpl getDaoImpl() {
		if (daoImpl == null) {
			daoImpl = new ProdutDAOImpl();
		}
		return daoImpl;
	}

	@Override
	public boolean insertProduct(Product product) {
		int id;
		try {
			id = products.get(products.size() - 1).getId();
		}
		catch(Exception e)
		{
			id = 0;
		}
		product.setId(id+1);
		return products.add(product);
	}

	@Override
	public boolean deleteProductById(int id) {
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getId() == id) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateProductById(Product product) {
	
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getId() == product.getId()) {
				products.set(i, product);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public Product getProductById(int id) {
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Product> getAllProductsByCat(String cat) {
		List<Product> tempList = new ArrayList<Product>();

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getCat().equalsIgnoreCase(cat)) {
				tempList.add(p);
			}
		}
		return tempList;
	}

	@Override
	public List<Product> getAllProductByLowPrice(float price) {
		List<Product> tempList = new ArrayList<Product>();

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getPrice() < price) {
				tempList.add(p);
			}
		}
		return tempList;
	}

	@Override
	public List<Product> getAllProductByHighPrice(float price) {
		List<Product> tempList = new ArrayList<Product>();

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getPrice() > price) {
				tempList.add(p);
			}
		}
		return tempList;
	}

	@Override
	public List<Product> getAllProductByBetweenPrice(float pricelow, float pricehigh) {
		List<Product> tempList = new ArrayList<Product>();

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.getPrice() > pricelow && p.getPrice() < pricehigh) {
				tempList.add(p);
			}
		}
		return tempList;
	}
}