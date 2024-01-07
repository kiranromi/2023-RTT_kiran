package inheritence;

public class Circle extends Shape  {
	
	private double diameter;
	
	//This functionality is only for a circle because a circle does not have a 
	
	public double getRadius() {
		return diameter/2;
		}
	public double getDiameter() {	
	return diameter;

}
	public void setDiameter(double diameter) {
		
		this.diameter  = diameter;
	}
}