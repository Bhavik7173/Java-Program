package com.gi.ui;

import java.util.List;
import java.util.Scanner;

import com.gi.daoimpl.ProdutDAOImpl;
import com.gi.daoimpl.UserDAOImpl;
import com.gi.model.Cart;
import com.gi.model.Product;
import com.gi.model.User;

public class UserScreen {
	Scanner sc = new Scanner(System.in);

	public void userMenu() {
		int ch = 0;
		UserDAOImpl userDAO = UserDAOImpl.getUserDAOImpl();
		User u = null;
		do {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("0.Exit");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 2:
				System.out.println("Enter Email ");
				String email = sc.next();
				
				System.out.println("Enter password ");
				String pass = sc.next();
				
				//u = userDAO.login(email, pass);
				u = userDAO.login(email, pass);
				if(u==null)
					System.out.println("Email and password does not match");
				else
					productMenu(u);
				break;
			case 1:
				u = new User();
				System.out.println("Enter name ");
				u.setName(sc.next());
				
				System.out.println("Enter Email ");
				u.setEmail(sc.next());
				
				System.out.println("Enter password ");
				u.setPassword(sc.next());
				
				System.out.println("Enter city ");
				u.setCity(sc.next());
				
				System.out.println("Enter Mobile ");
				u.setMobile(sc.nextLong());				
				
				boolean status = userDAO.register(u);
//				boolean status = userDAO.register(new User("Bhavik","b@gmail.com","bbb","b",12345));
				
				if(status==false)
					System.out.println("Contact to admin");
				else
					System.out.println("reg done!!!");
				break;
			case 0:
				System.out.println("Thanks");
				break;

			default:
				System.out.println("invlalid option");
			}
		} while (ch != 0);
	}

	public void productMenu(User user) {
		int ch = 0;
		Product pr = null;
		int id,pr_quantity;
		float p1,p2;
		String pr_name;
		boolean status;
		List<Product> products;
		List<Cart> cart_products;
		String cat;
		ProdutDAOImpl daoImpl = ProdutDAOImpl.getDaoImpl();
		System.out.println("Welcome "+user.getName());
		do {
			System.out.println("1.search Product by id");
			System.out.println("2.search Product by cat");
			System.out.println("3.search Product by low price range");
			System.out.println("4.search Product by high price range");
			System.out.println("5.search Product by between price range");
			System.out.println("6.disp all products");
			System.out.println("7.Purchase / add to cart");
			System.out.println("8.Check out");			
			System.out.println("0.Logout");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter product id you want to search");
				id = sc.nextInt();
				pr = daoImpl.getProductById(id);
				if(pr==null)
					System.out.println("can not find product with id ..."+id);
				else
					System.out.println(pr);
				break;
			case 2:
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
			case 3:
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
			case 4:
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
			case 5:
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
			case 6:
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
			case 7:
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
				id = sc.nextInt();
				pr = daoImpl.getProductById(id);
				if(pr==null)
					System.out.println("can not find product with id ..."+id);
				else {
					System.out.println("Find the product by id" + pr);
					System.out.println("\nEnter the qauntity of prduct which you want to purchase it...");
					int qauntity = sc.nextInt();
					Cart cart = new Cart(pr, qauntity);
					boolean s = user.addToCart(cart);
					if(s==true)
						System.out.println("add to cart");
					else
					{
						System.out.println("sorry");
					}
				}
				break;
			case 8:
				double total = 0;
				List<Cart> carts = user.getCarts();
				for(Cart c : carts)
				{
					Product p = c.getProduct_price();
					System.out.println(p);
					System.out.println(c.getQuantity());
					System.out.println(p.getPrice()*c.getQuantity());
					total += p.getPrice() * c.getQuantity();
					System.out.println("---------------------------------------------");
				}
				System.out.println("Total ");
				break;
		
			case 0:
				System.out.println("Logout successfully");
				break;

			default:
				System.out.println("invlalid option");
			}
		} while (ch != 0);
	}

}
