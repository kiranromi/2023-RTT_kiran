package coffeeshoptest;

public class StringPracticeClass {

	public static void main(String[] args) {
		String s1 = "welcome";
		String s2 = "Welcome";
		// These two things are not equal
		
		//this is actually a string in memory that 0 charactors and lengthof 0
		String empty ="";
		//This is a string that has not been allocatedin memory yet
		String  nullstring = null; 
		String  nsl = null; 
		if(nullstring == null)	{
			//This is true
		}	
		
      if(empty.equals(nullstring)){
	// this will evaluate to false
}
      if( empty.equals(nullstring)) {
    	 // this is True 
      }
      if(nullstring == null) {
    	  nullstring = new String("now it's in meomory");
      }
      //This is all okay with primitives
      
      int x = 5;
      int y= 6;
      if (x==y) {
    	  
    	  
      }
	}
	

}
