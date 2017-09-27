//Shivneel Chand
//9-25-17
//This describes the quadratic graph to the user.
public class Quadratic {
	public static void quadrDescriber(double a, double b, double c) {
		System.out.println("Description of the graph of:");
		System.out.println("y = " + a + " x^2 + " + b + " x " + c);
		System.out.println();
		
		System.out.print("Opens: ");
		if(a<0) {
			System.out.println("Down");
		}else
			System.out.println("Up");
		
		double aOS = -1*b/(2*a);
		System.out.println("Axis of Symmetry: " + aOS);
		System.out.println("Vertex: (" + aOS + ", " + "IDK WHAT GOES HERE YET" + ")");
		System.out.println("x-intercept(s): " + "Still working on this too");
		System.out.println("y-intercept: " + c);
	}
}
