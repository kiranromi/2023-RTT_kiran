package stringmethod;

public class StringComparesTo {

	public static void main(String[] args) {
		
		// there are three ways to compare strings
		//By using equals()method
		
		String s1= "perscholas";
		String s2 = "Perscholas";
		String s = new String("Perscholas");
		System.out.println(s1.equalsIgnoreCase(s2) );
		System.out.println(s1.equals(s2) );
		System.out.println(s1==s2) ;
		System.out.println(s1==s) ;
		System.out.println(s1==s2) ; // By using == operetor
		
		System.out.println(s2.equals(s) );
		
		//by using compareTo method
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s));
		
		
		
		

	}

}
