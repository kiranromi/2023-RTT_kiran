package ifelseexample;

import java.util.Scanner;

public class IfElseExamplesFive {

	public static void main(String[] args) {
		/*5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F, according to the following criteria:
		A: 90-100
		B: 80-89
		C: 70-79
		D: 60-69
		F: <60
		Use the Scanner class to accept a number score from the user to determine the letter grade. Print out “Score out of range” if the score is less than 0 or greater than 100.
 */
	
	Scanner sc = new Scanner(System.in);
	int score = sc.nextInt();
	
	
	if(score<0 || score>100 ) {
		System.out.println("Score out of range");
	}
	else if (score >= 90 && score <=100) {
		
		System.out.println("A");
	}else if (score >= 80 && score <=89) {
		
		System.out.println("B");
	}
       else if (score >= 70 && score <=79) {
		
		System.out.println("c");
	}  else if (score >= 60 && score <=69) {
		
		System.out.println("D");
	}  else if ( score <=60) {
		
		System.out.println("F");
	}
	}

}
