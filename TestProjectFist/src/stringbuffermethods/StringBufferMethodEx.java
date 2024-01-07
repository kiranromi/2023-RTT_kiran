package stringbuffermethods;

public class StringBufferMethodEx {

	public static void main(String[] args) {
		
			// ------ insert()----------------
		 	StringBuffer s = new StringBuffer("Java");
		    s.insert(4, "language");
		    System.out.println(s);
		    // --------- replace()---------
		    StringBuffer sT = new StringBuffer("Java");
		    sT.replace(0, 2, "Hello"); 
		    System.out.println(sT);
		    
		    StringBuffer str = new StringBuffer("Welcome to Java Fullstack ");
		    System.out.println("Original string: " + str);
		    System.out.println("Substring with start index: " + str.substring(5));
		    System.out.println("Substring with start and end index: " + str.substring(5, 10));
		    
		    
		    
		    
		    
		    
		    }
		


	}


