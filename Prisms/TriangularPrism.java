/* Write this concrete (non-abstract) class called TriangularPrism.  
 * It has 3 private fields (sideA, sideB, and sideC).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.
 * 
 * Math Note:
 * Perimeter refers to the perimeter of the base - the sum of all the sides.
 * To find the area of a triangle given 3 side lengths, look up Heron's formula.  
 * It uses half the perimeter.  (Why might you want to use 0.5 instead of 1/2?)
 */

public class TriangularPrism extends Prism{
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	public TriangularPrism(double height) {
		super(height);
	}

	public double calcAreaOfBase() {
		double s = calcPerimeter() / 2;
		return Math.sqrt((s * (s-sideA) * (s-sideB) * (s-sideC)));
	}


	public double calcPerimeter() {
		return sideA + sideB + sideC;
	}

}
