package coffeeshoptest;

import java.util.Scanner;

public class ScannerEx {
	
 public static void main(String[] args) {
	 
	 Scanner sc = new Scanner(System.in);
	
	 System .out.println(" What is your favorite movie?");
	 
	 String userInput = sc.nextLine();
	 
	 // do math and logic
	 if( userInput.equalsIgnoreCase("Star wars")) {
		 System.out.println( "Mine too!");
		
	 }else {
		 System.out.println("You have bad taste!");
		 
	 }
	 System.out.println( "You entered   "  + userInput);
	 
	 
	 
	 
	 
	 
		
	

	}

}
