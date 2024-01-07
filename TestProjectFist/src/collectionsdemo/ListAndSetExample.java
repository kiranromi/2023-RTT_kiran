package collectionsdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListAndSetExample {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		
		// get get by a position from a list.
		stringList.get(1);
		
		
		Set<String> stringSet = new HashSet<>();
		stringSet.add("c");
		stringSet.add("b");
		stringSet.add("a");
		
		stringSet.add("a");

		// can not get by position from a set.   The get function does not exist
		//stringSet.get
		
		for ( String string : stringSet ) {
			System.out.println(string);
		}
		

	}

}
