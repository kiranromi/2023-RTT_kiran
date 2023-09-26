package coffeeshoptest;

import java.util.Scanner;

public class IfElseMarks {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		System.out.println( " Enter the number");
		int x= sc.nextInt();
		if(x<0 || x>100) {
			System.out.println( "Score out of range");
		}else if(x>=90 && x<=100) {
			System.out.println( "A");
		}else if (x>=80 && x<= 89 ) {
			System.out.println( "B");
		}else if (x>=70 && x<= 79 ) {
			System.out.println( "C");
		}else if (x>=60 && x<= 69 ) {
			System.out.println( "D");
		}else if(x<60) {
			System.out.println( "F");}
	}

}
