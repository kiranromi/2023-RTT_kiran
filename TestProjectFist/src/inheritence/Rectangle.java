package inheritence;

public class Rectangle extends Shape {
	private double height;
	private double width; 
	
	public Rectangle() {
		super();
	}
	// This is the specific formula for the area of a rectangle. This is implementation of the Area interface
	public  double calculateArea() {
		return height * width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getwidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	
}
	

	


