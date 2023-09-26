package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CoffeeShop {
	
	List <Product> products = new ArrayList<>();
	//this is a class member variable to make it easy
	Scanner input = new Scanner(System.in);
	
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
		
		//printProduct(coffee);
		//printProduct(tea);
		//printProduct(cookie);
		
		Product sandwich = new Product();
		sandwich.setName("Egg & Cheese Muffin");
		sandwich.setPrice(19.99);
		products.add(sandwich);
		
		
		
		
		
		
		printAllProducts();
	}
	public void printProduct( Product  product) {
		System.out.println("Product name :" + product.getName()  + "  price : " + product.getPrice());
	}
	 public void printAllProducts() {
		for( Product product : products ) {
			//printProduct(product);
			System.out.println("Product name :" + product.getName()  + "  price : " + product.getPrice());
		}
		
	}   
		
		
		
		
	

	public static void main(String[] args) {
	  CoffeeShop cf = new CoffeeShop();
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
		System.out.println("Total sale is  \t " + df.format(totalSale));
	}
		
		public int userSelect() {
			System.out.println( "1 ) print the menu items and prices");
			System.out.println( "2 ) Add an items in your order ");
			System.out.println( "3 ) Print the items in your order ");
			System.out.println( "4 )  Checkout");
			
			System.out.println("\nWhat do you want to do?");
			int select = input. nextInt();
			return select;
		}

}
