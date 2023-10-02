package polymorphismandinterfaceassignment;

public class AdultUser implements LibraryUser {
	
	int age;
	
	String bookType;
    
	
	public void registerAccount() {
		
		if (age>=12) {
			System.out.println("You have successfully\r\n"
					+ "registered under an Adult Account.”");
					
		if(age<=11) {
				System.out.println("Sorry, age must be greater than 12 to\r\n"
						+ "register as an adult.");
				
			}
		}
	}
	public void requestBook() {
		
		if("Fiction".equalsIgnoreCase(bookType)) {
			System.out.println("Book Issued\r\n"
					+ "successfully, please return the book within 7 days.");			
		}else {
			System.out.println("Oops, you are allowed to take only adult Fiction\r\n"
					+ "books.");
			
		}
	
		
		
	}
	
	
	
}
