package coffeeshoptest;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopTest {
	 
 List<Product> products = new ArrayList<>();
 
 public void setupProducts() {
 
	Product coffee = new Product();
	coffee.setName("Coffee");
	coffee.setPrice(5.44);
	products.add(coffee);
	
	
	Product tea = new Product();
     tea.setName("Tea");
	 tea.setPrice(4.33);
	products.add(tea);
	
	Product cookie = new Product();
	cookie.setName("Cookie");
	cookie.setPrice(6.77);
	products.add(cookie);
	
	printProduct(coffee);
	printProduct(tea);
	printProduct(cookie);
 }
	
	

	public void printProduct(Product product) {
		System.out.println("Product name : " + product.getName() + "	Price : "+"$"+  product.getPrice());
	}

	
 public static void main(String[] args) {
	 CoffeeShopTest cfst = new CoffeeShopTest();
	 cfst.setupProducts();
	 
		
		

	}

}
