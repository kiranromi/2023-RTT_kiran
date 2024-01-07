package stringmethod;

import java.util.StringJoiner;

public class StringJoinerDemoTwo {

	public static void main(String[] args) {
		//---- passing comma(,) and square-brackets as delimiter  	----
		StringJoiner joinData = new StringJoiner(",", "[",  "]");
		      // ---Adding values to StringJoiner  ---
				 joinData.add("Java");  
				 joinData.add("Python");  
				 joinData.add("C Sharp");  
				 joinData.add("JavaScript");  
			     System.out.println(joinData);


	}

}
