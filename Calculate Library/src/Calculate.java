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
		int wholeNumbah = numerator/denominator;
		int newNumerator = numerator%denominator;
		return (wholeNumbah + "_" + newNumerator + "/" + denominator);
	}
	//converts two binomials into a quadratic equation
	public static String foil(int a, int b, int c, int d, String variable) {
		int middleNumber = b*c + a* d;
		return (a*c + variable + "^2 + " + middleNumber + variable + " + " + b*d);
	}
	// accepts two integers, and returns true if the first number is evenly divisible and false if there
	//a remainder.
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if(numerator % denominator == 0) {
			return true;
		}else {
			return false;
		}
	}
	//returns the absolute value of a number.
	public static double absValue(double numbah) {
		if(numbah < 0) {
			return -1*numbah;
		}else{
			return numbah;
		}
	}
	//takes two numbers and returns the largest value
	public static double max(double numbah1, double numbah2) {
		if(numbah1<numbah2) {
			return numbah2;
		}else {
			return numbah1;
		}
	}
	//takes three numbers, and returns the largest value
	public static double max(double numbah1, double numbah2, double numbah3) {
		if(numbah1>numbah2 && numbah1>numbah3) {
			return numbah1;
		}
		if(numbah2>numbah1 && numbah2>3){
			return numbah2;
		}else {
			return numbah3;
		}
	}
	//takes two integers and returns the lower integer
	public static int min(int numbah1, int numbah2) {
		if(numbah1 < numbah2) {
			return numbah1;
		}else {
			return numbah2;
		}
	}
	//Takes a double and returns the double rounded correctly to two decimal places
	public static double round2(double numbah) {
		double roundedVal = 0;
		int digits = 0;
		while(numbah > 1) {
			numbah /= 10;
			digits++;
		}
		for(int i = 0; i < digits; i++) {
			roundedVal = (int) numbah * 10 *i % 100;
		}
		return roundedVal;
	}
	
}