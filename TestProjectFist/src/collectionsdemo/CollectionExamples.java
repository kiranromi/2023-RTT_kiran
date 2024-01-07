package collectionsdemo;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionExamples {

	public static void main(String[] args) {
		// pos 012345
	    // val abcdef

				ArrayList<String> strings = new ArrayList<>();

				strings.add("one");
				strings.add("two");
				strings.add("three");

				for (String string : strings) {
					System.out.println(string);
				}
				System.out.println("==========================================");

				Iterator<String> itr = strings.iterator();
				while (itr.hasNext()) {
					String string = (String)itr.next();
					System.out.println(string);
				}

	}

}
