package inheritence;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//area = l*w
		Rectangle rect = new Rectangle();
		rect.setName("Rectangle");
		rect.setHeight(10);
		rect.setWidth(5);
		
		// area =pi* r*r
		
		Circle circle = new Circle();
		circle.setName("Circle");
		circle.setDiameter(100);
		
		List<Shape>shapes = new ArrayList<>();
		shapes.add(rect);
		shapes.add(circle);
	

	}

}
