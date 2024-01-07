package substringhomework;

public class SubStringHomeworkTwo {

	public static void main(String[] args) {
		int example;
		int startIndex = example.indexOf("is");
		 int endIndex = example.indexOf(" ", startIndex + 1);
		 
		 if ( startIndex!=-1&& endIndex! =-1) {
			 String extractedSubstring = example.subString(startIndex ,endIndex  );
			 System.out.println("The extracted Substring containg 'is'  "+ extractedSubstring);
			 
		 }
		 else {
			 System.out.println("The word 'is' was not in the string");
		 }
		

	}

}
