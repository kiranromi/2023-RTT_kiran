package stringmethod;

public class StringMethodLength {

	
   public static void main(String[] args) {
	   
    String str1 = "Java";
	String str2 = "";

    System.out.println(str1.length());  // 4
    System.out.println(str2.length());  // 0
	System.out.println("Java".length());  // 4
    System.out.println("Java\n".length()); // 5 next line is  one character
    System.out.println("Java\t".length()); //Here tab is a one character
    System.out.println("Learn Java".length());// 10 here space is a character
    System.out.println("LearnJava".length());
		    
		

	}

}
