//Shivneel Chand
//September 6th 2017
//My self written math Library 
//It contains a series of methods to do basic math functions.
public class Calculate {	
	//square the input
	public static int square(int numbah) {
		return numbah * numbah;
	}
	
	public static int cube(int numbah) {
		return numbah * numbah * numbah;
	}
	
	public static double average(double numbah1, double numbah2) {
		return (numbah1 + numbah2)/2;
	}
	
	public static double average(double numbah1, double numbah2, double numbah3) {
		return (numbah1 + numbah2 + numbah3) / 3;
	}
	
	public static double toDegrees(double numbah) {
		return (numbah/3.14159 * 180);
	}
	
	public static double toRadians(double numbah) {
		return ((numbah *3.14159) / 180);
	}
	
	public static double discriminant(double a, double b, double c) {
		return (b*b - (4*a*c));
	}
}