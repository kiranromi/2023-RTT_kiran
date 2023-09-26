package coffeeshoptest;

import java.util.Scanner;

public class ControlFlowStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 50;
		if(x<10) {
			System .out.println("Less than 10");
		}else if (x>10&& x<20) {
			System.out.println("Between 10 and 20");
			
		}if(x>=20) {
			System.out.println( "Greater than or equal to 20");
		}
			

	}

}
