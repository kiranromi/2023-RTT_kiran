package stringmethod;

public class SubStringDemo {

	public static void main(String[] args) {
		//---------------0123456789012345
		String string = "This is a string";
		
		//substring with a start and end an end
		
		String sub = string.substring(5,7);
		System.out.println(sub);
		
		// substring with just a start
		String sub1 = string.substring(5);
		System.out.println(sub1);
		
		String filename = "someimage.jpg";
		
		int lastDot = filename.lastIndexOf("j");
		String ext = filename.substring(filename.lastIndexOf(","));
		System.out.println(ext);
		
	 String name = "Eric heilig";
	 int spacePosition = name.indexOf(" ");
	 
	 String firstname = name.substring(0,spacePosition );
	 System.out.println(firstname);
	 
	 String lastname = name.substring(name.indexOf(" ") );
	 
	 System.out.println(lastname);
	 
	 
	 
		
		
		

	}

}
