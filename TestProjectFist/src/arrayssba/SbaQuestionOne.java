package arrayssba;

import java.util.ArrayList;
import java.util.List;

public class SbaQuestionOne {
	Integer [] array = new Integer[10];
	
	public void replace(int position) {
		
	}
	public void newfunction() {
		//Initialize this array so that all elements have the value 10
		
		
		
			// use a for loop to do it
			
			// copy all of the values from array into list and print the message.
			// I have added (value) at position[position]
			
			List<Integer> list = new ArrayList<>();
			
		   for( int pos = 0;pos <array.length; pos++) {
			   
			   int a= array[pos];
			   list.add(a);		   
			   System.out.println("I have added "+ a +" at position "+pos);	
				
			}
		
	}

	public static void main(String[] args) {
		
		SbaQuestionOne q1 = new SbaQuestionOne();
		 // q1.run();
		q1.replace(-1);
			
		}
	
		
		
		
		// use a for loop is a int pos use the length of the array
	  
	   
		// will be 2 lines of code inside the for loop
		
		//I want you to create a new question1 object and move all the code from this main method into a new function
		
        // questionOne q1 = new questionOne();
		//  q1.run();
		// then I want you to move array to be a class level variable
		//Implement a function .....public void replace (int position)
		//the function will set the value at position to -1
		//who knows what the empty string is???   ""
		// What is the difference between "" and null
		// an empty string "" is actually a string object created in memory with no characters in it . Hence " " null is a veriable 
		//  Hence " " null is a variable that has not even been created in memory.
		
		//Write a function that will 
		//1) create a new list(local variable)
		// 2)loop over array (at this point it will be a class variable)
		//3) add all elements of the array that are not equal to -1 to the new list just created
		//4)  return the new list created. 
		
	
	private void run() {
		// TODO Auto-generated method stub
		
	}		
	
    public List<String>filterArray() {
    	
    	List<String> newList  = new ArrayList<>();
    	for (Integer element: array ) {
    		if(!element.equals ("")) {
    			newList.add(element + "");
    }
    	
    	//for(int pos =0; pos < array.length;pos++) {
    	//	int a = array[pos];
    	//	if(a!=-1) {
    	//	list1.add(a+ "");
    	//	System.out.println(list1.add(a+ ""));	
    			
    			
    		}
    		return newList;
    }	

}
