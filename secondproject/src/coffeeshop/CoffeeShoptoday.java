package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class CoffeeShoptoday {
	
	List <Product> products = new ArrayList<>();
	
	public void setupProducts() {
	Product coffee = new Product();
		coffee.setName("coffee");
		coffee.setPrice(5.44);
		products.add(coffee);
		
		Product tea  = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);
		
		Product cookie = new Product();
		
	cookie.setName("cookie");
		cookie.setPrice( 6.77);
		products.add(cookie);
		
		printProduct(coffee);
		printProduct(tea);
		printProduct(cookie);
		
		Product sandwich = new Product();
		sandwich.setName("Egg & Cheese Muffin");
		sandwich.setPrice(19.99);
		products.add(sandwich);
		
		
		
		
		
		printAllProducts();
	}
	public void printProduct( Product  product) {
		System.out.println("Product name :" + product.getName()  + "price : " + product.getPrice());
	}
	public void printAllProducts() {
		for( Product product : products ) {
			printProduct(product);
		}
	}
		
		
		
		
	

	public static void main(String[] args) {
	  CoffeeShoptoday cf = new CoffeeShoptoday();
	  cf.setupProducts();
		
		//the value in each product in the price
		double coffee = 5.43d;
		double tea = 4.33d;
		double cookies = 6.76d;
		
		double subTotal = 0;
		
		// 3 items of the first product 
		subTotal = coffee * 1;
		
		// 4 items of the 2nd product
		subTotal = subTotal + (tea * 1);
		// 2 items of the the 3rd product
		subTotal = subTotal + (cookies * 2);
		//System.out.println("subtotal : "+ subTotal);
		DecimalFormat df = new DecimalFormat("0,000.00");
		System.out.println("subtotal is \t "+ df.format(subTotal));
		double salesTax = subTotal * 0.01;
		System.out.println("salesTax is \t " + df.format(salesTax));
		double totalSale = subTotal + salesTax;
		System.out.println("total sale is  \t " + totalSale);
		
		
		
		System.out.println("subtotal : "+ df.format(subTotal));
		
		
		
		

	}

}
