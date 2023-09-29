package calculatortest;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

	double result;

	public static void main(String[] args) {
		/*Create a small calculator .. it will be able to do 4 operations - add, subtract, multiply and divide. 
		//Each of these will be a single method that does that operation.  
		//Ask the user for 2 numbers and then ask the user which operation they want to do.  
		Then do that operation and print the result.   Each operation should not print its own results. 
		All operations should work with double values. (edited) 
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter two numbers");

		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();

		System.out.println(" Which operation do you want to do ? Add , Substract , Multiply or Divide");

		String operation = sc.next();
		CalculatorTest ct = new CalculatorTest();
		
		if(operation.equalsIgnoreCase("add")) {
			ct.add(num1, num2);
		}else if(operation.equalsIgnoreCase("substract")) {
			ct.substract(num1, num2);
		}else if(operation.equalsIgnoreCase("multiply")) {
			ct.multiply(num1, num2);
		}else if(operation.equalsIgnoreCase("divide")) {
			ct.divide(num1, num2);
		}

		
		
		
		

	}

	public void add(double num1, double num2) {
		System.out.println("Addition Result "+ (num1 + num2));	
	}

	public void substract(double num1, double num2) {
		System.out.println("Substraction Result "+ (num1 - num2));

	}

	public void multiply(double num1, double num2) {
		double numM =num1*num2;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Multiplication Result "+ df.format(numM));
	}
	public void divide(double num1, double num2) {
		double numd = num1/num2;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Division Result "+ (df.format(numd)));

	}





}
