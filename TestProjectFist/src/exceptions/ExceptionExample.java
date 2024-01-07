package exceptions;

import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		
    Scanner scanner = new Scanner(System.in);
		
	//Try to make it so the user has to keep trying until they enter a number
    //hint: use a while loop and a break ;
		
		try {
			System.out.println("Please enter a number:");
			int x = scanner.nextInt();
			//This code execute only if no exceptions occurs
			System.out.println("you entered the number:" + x);
			
		} catch (Exception e) {
			// this code executes only if any exceptions occurs
			System.out.println("You did not enter a number");
			
		}finally {
			// finally is optional , meaning you do not have to implement it
			//This code executed no matter what 
			// most of the time this is used to resource clanup
			System.out.println("This excute no matter what");
			scanner.close();
		}

	}

}
