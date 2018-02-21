//Shivneel Chand
//2-21-18

/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism{
	private double length, width;
	
	public RectangularPrism(double height, double length, double width) {
		super(height);
		this.length = length;
		this.width = width;
	}


	public double calcAreaOfBase() {
		return length * width;
	}

	public double calcPerimeter() {
		return length*2 + width*2;
	}
}
