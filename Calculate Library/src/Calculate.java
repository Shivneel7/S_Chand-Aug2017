//Shivneel Chand
//September 6th 2017
//My self written math Library 
//It contains a series of methods to do basic math functions.
public class Calculate {	
	//square the input
	public static int square(int numbah) {
		return numbah * numbah;
	}
	// cubes the input
	public static int cube(int numbah) {
		return numbah * numbah * numbah;
	}
	//averages two inputs
	public static double average(double numbah1, double numbah2) {
		return (numbah1 + numbah2)/2;
	}
	//averages three inputs
	public static double average(double numbah1, double numbah2, double numbah3) {
		return (numbah1 + numbah2 + numbah3) / 3;
	}
	//converts radians into degrees
	public static double toDegrees(double numbah) {
		return (numbah/3.14159 * 180);
	}
	//converts degrees to radians
	public static double toRadians(double numbah) {
		return ((numbah *3.14159) / 180);
	}
	//calculates the discriminant
	public static double discriminant(double a, double b, double c) {
		return (b*b - (4*a*c));
	}
	//converts to mixed number improper fraction
	public static String toImproperFrac(int wholeNumbah, int numerator, int denominator) {
		int newNumerator = wholeNumbah * denominator + numerator;
		return (newNumerator + "/" + denominator);
	}
	//converts improper fraction to mixed number
	public static String toMixedNum(int numerator, int denominator) {
		return ();
	}
	
}