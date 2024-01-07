package stringmethod;

import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {
		
	// {Name:Tony:LastName,Strak}	this is it!
		
		StringJoiner sj1 = new StringJoiner(",","{","}") ;
		
		StringJoiner sj2 = new StringJoiner(":","[","] 																																																																																					") ;
		
		sj1.add("Name").add("Tony");
		
		sj2.add(" LastName").add("Stark");
		
		System.out.println(sj1.merge(sj2).toString());
		
		
		
		

	}

}
