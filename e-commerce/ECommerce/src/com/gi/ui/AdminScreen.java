package com.gi.ui;

import java.util.List;
import java.util.Scanner;

import com.gi.dao.ProductDAO;
import com.gi.daoimpl.ProdutDAOImpl;
import com.gi.model.Product;

public class AdminScreen {
	Scanner sc = new Scanner(System.in);
	private Product getProduct()
	{
		Product product = new Product();
		System.out.println("Enter name");
		product.setName(sc.next());
		System.out.println("Enter desc");
		product.setDesc(sc.next());
		System.out.println("Enter Price");
		product.setPrice(sc.nextFloat());
		System.out.println("Enter Cat");
		product.setCat(sc.next());
		return product;
	}
	public void adminMenu() {
		int ch = 0;
		Product pr = null;
		int id;
		float p1,p2;
		boolean status;
		List<Product> products;
		String cat;
		ProdutDAOImpl daoImpl = ProdutDAOImpl.getDaoImpl();
		do {
			System.out.println("1.Insert new Product");
			System.out.println("2. delete Product");
			System.out.println("3.update Product");
			System.out.println("4.search Product by id");
			System.out.println("5.search Product by cat");
			System.out.println("6.search Product by low price range");
			System.out.println("7.search Product by high price range");
			System.out.println("8.search Product by between price range");
			System.out.println("9.disp all products");
			System.out.println("0.Exit");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				pr = getProduct();
				status = daoImpl.insertProduct(pr);
				if(status) // if(status == true)
					System.out.println("inserted...");
				else
					System.out.println("conatct  to admin...");
//				daoImpl.insertProduct(new Product("milk", "amul milk", 100, "dairy"));
//				daoImpl.insertProduct(new Product("milk1", "amul milk1", 10, "dairy"));
//				daoImpl.insertProduct(new Product("milk2", "amul milk2", 200, "dairy"));
				
				break;
			case 2:
				System.out.println("Enter product id you want to delete");
				id = sc.nextInt();
				status = daoImpl.deleteProductById(id);
				if(status) // if(status == true)
					System.out.println("deleted...");
				else
					System.out.println("can not find product with id ..."+id);
				break;
			case 3:
				System.out.println("Enter product id you want to update");
				id = sc.nextInt();
				pr = getProduct();
				pr.setId(id);
				status = daoImpl.updateProductById(pr);
				if(status) // if(status == true)
					System.out.println("updated...");
				else
					System.out.println("can not find product with id ..."+id);
				break;
			case 4:
				System.out.println("Enter product id you want to search");
				id = sc.nextInt();
				pr = daoImpl.getProductById(id);
				if(pr==null)
					System.out.println("can not find product with id ..."+id);
				else
					System.out.println(pr);
				break;
			case 5:
				System.out.println("Enter product cat you want to search");
				cat = sc.next();
				products = daoImpl.getAllProductsByCat(cat);
				if(products.isEmpty())
					System.out.println("can not find product with cat ..."+cat);
				else
				{
					for(Product pr1 : products)
					{
						System.out.println(pr1);
					}
				}
				break;
			case 6:
				System.out.println("Enter product price below you want to search");
				p1 = sc.nextFloat();
				products = daoImpl.getAllProductByLowPrice(p1);
				if(products.isEmpty())
					System.out.println("no products found below price..."+p1);
				else
				{
					for(Product pr1 : products)
					{
						System.out.println(pr1);
					}
				}
				break;
			case 7:
				System.out.println("Enter product price above you want to search");
				p1 = sc.nextFloat();
				products = daoImpl.getAllProductByHighPrice(p1);
				if(products.isEmpty())
					System.out.println("no products found above price..."+p1);
				else
				{
					for(Product pr1 : products)
					{
						System.out.println(pr1);
					}
				}
				break;
			case 8:
				System.out.println("Enter product price between you want to search");
				p1 = sc.nextFloat();
				p2 = sc.nextFloat();
				products = daoImpl.getAllProductByBetweenPrice(p1,p2);
				if(products.isEmpty())
					System.out.println("no products found between price..."+p1);
				else
				{
					for(Product pr1 : products)
					{
						System.out.println(pr1);
					}
				}
				break;
			case 9:
				System.out.println("Enter product price between you want to search");
				
				products = daoImpl.getAllProducts();
				if(products.isEmpty())
					System.out.println("no product found...");
				else
				{
					for(Product pr1 : products)
					{
						System.out.println(pr1);
					}
				}
				break;
			case 0:
				System.out.println("Thanks");
				break;

			default:
				System.out.println("invlalid option");
			}
		} while (ch != 0);
	}

}
