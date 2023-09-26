package stringmethod;

import java.util.Scanner;

public class StringTokenExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        // Write your code here.
              
        String regex = "[^a-zA-Z0-9]+";
        
        String str = s.replaceAll(regex, " ").trim();
        String[] strArray = str.split(" ");
       
        System.out.println(strArray.length);
       
        for(int i=0;i<strArray.length;i++) {            
            System.out.println(strArray[i]);
        }
         
        
        
    }

}
