package polymorphismandinterfaceassignment;

public class KidUser implements LibraryUser {
	
	int age;
	String bookType;
	String  Kids;
	
	public void registerAccount() {
		if(age<=11) {
			System.out.println("You have successfully registered\r\n"
					+ "under a Kids Account");
		}
		if (age>11) {
			System.out.println("Sorry, age must be less than 12 to register\r\n"
					+ "as a kid.");
		}
		
	}
	public void requestBook() {
		
		if(bookType == Kids) {
			System.out.println("Book issued successfully,\r\n"
					+ "please return the book within 10 days");
		}else {
			System.out.println("Oops, you are allowed to take only kids books.");
			
		}
			
	}
	
	
	

}
