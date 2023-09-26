package stringmethod;

public class StringReplaceMethod {

	public static void main(String[] args) {
		String s = "lava is a best programming language.";
		System.out.println("Replace python instead of java:"+"\t"+s.replace( 'l','j' ))  ;
		//System.out.println("Replace java to pyton :"+"\t"+s .replace( "java","python" ))  ;
		
		
		
		String s1 = "Java345is6932fun";
		String s2 ="Today4579is 0954@Holiday"; 
		
		// regex is for sequence of digits
		
		String regex = "\\d+";
		System.out.println( s1.replaceAll(regex, " "));  
		System.out.println( s2.replaceAll(regex, " "));// replace only numbers
		

	}

}
