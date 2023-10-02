package polymorphismandinterfaceassignment;

public class LibraryInterfaceDemo {

	public static void main(String[] args) {
		
		KidUser kdu1 = new  KidUser();
		
		kdu1.age =10;
		
		kdu1.bookType = "Kids";
		
		kdu1.registerAccount();
		
		KidUser kdu2 = new  KidUser();
		
		kdu2.age= 18;
		
		kdu2.bookType = "Fiction";
		
		kdu2.registerAccount();
		
		AdultUser user1 = new AdultUser();
		 user1.age = 5;
		 
		 user1.bookType = "kids";
		 
		 user1.registerAccount();
		 

			AdultUser user2 = new AdultUser();
			 user2.age = 23;
			 
			 user2.bookType = "Fiction";
			 
			 user2.requestBook();
		 
			 
		
		
		

	}

}
