package stringmethod;

public class LexicographicalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    String s = "welcometojava";
		    int k = 3;
		    String currStr = s.substring(0, k);
	        String lexMin = currStr;
	        String lexMax = currStr;
	  
	        // Consider all remaining substrings. We consider
	        // every substring ending with index i.
	        for (int i = k; i < s.length(); i++) {
	            currStr = currStr.substring(1, k) + s.charAt(i);
	            if (lexMax.compareTo(currStr) < 0)    
	                 lexMax = currStr;
	            if (lexMin.compareTo(currStr) > 0)
	                 lexMin = currStr;           
	        }
	 
	        // Print result.
	        System.out.println(lexMin);
	        System.out.println(lexMax);
	    

	}

}
