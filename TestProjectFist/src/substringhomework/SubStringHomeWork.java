package substringhomework;

public class SubStringHomeWork {

	public static void main(String[] args) {
		
		//find the position of the first -space in the string
		
        String example = "This is an example";
        int fpos = example.indexOf(" ");
        System.out.println("This is the position of first space: " +fpos);
        
        int lpos = example.lastIndexOf(" ");
        System.out.println("This is the position  of last space: " +lpos);
        //Substring
        String str = example.substring(fpos, lpos);
        System.out.println("This is substring between first and last space: " +str);
        
        //Substring between vowels
        
        String vowels = "";
        for(int i=0;i<example.length();i++) {
        	
          if(example.charAt(i)== 'a' || example.charAt(i)== 'e' || example.charAt(i)== 'i' || example.charAt(i)== 'o' || example.charAt(i)== 'u') {
        	  vowels = vowels + example.charAt(i);
        	}          
        	
        }
        System.out.println("Vowels in given String = "+vowels);
        char fcharofvowels = vowels.charAt(0);
        char lcharofvowels = vowels.charAt(vowels.length()-1);
        
        int x= example.indexOf(fcharofvowels);
        int y = example.lastIndexOf(lcharofvowels);        
        System.out.println("X = "+x);
        System.out.println("Y = "+y);
        
        String str2 = example.substring(x, y);
        System.out.println("Substring between Vowels in given String = "+str2);
        
      
        String[]examples = example.split(" ");
        String strexample = examples.toString();
        System.out.println("strexample === "+strexample);
        for(int i=0; i<strexample.length();i++){
        	System.out.println(strexample.charAt(i));
        	
        }
        
        
       
        		
        	
        
        	
        }
        
        
        
        

	}


