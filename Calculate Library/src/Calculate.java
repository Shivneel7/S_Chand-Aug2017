//Shivneel Chand
//September 6th 2017
//My self written math library 
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
		}else if(numbah2>numbah1 && numbah2>numbah3){
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
		int tempInt = (int) (numbah *1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt / 10;
		if(roundNum >=5) {
			tempInt++;
		}else if(roundNum <= -5){
			tempInt--;
		}
		return tempInt/100.0;
	}
	//Takes one double and one positive integer, and raises the double to the power of 
	//the integer.
	public static double exponent(double base, int exponent) {
		double result = base;
		for(int i = 1; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	//Returns the factorial of the value passed
	public static int factorial(int numbah) {
		int result = 1;
		for(int i = 1; i <= numbah; i++) {
			result*= i;
		}
		return result;
	}
	//returns a true or false based on whether the number given is prime or not.
	public static boolean isPrime(int numbah) {
		if(numbah <2) {
			return false;
		}
		int numOfFactors = 0;
		for(int i = 2; i <= numbah; i++) {
			boolean result = isDivisibleBy(numbah,i);
			if(result == true) {
				numOfFactors++;
			}
		}
		if(numOfFactors>1) {
			return false;
		}else {
			return true;
		}
	}
	//This method takes two integers and returns the greatest common factor.
	public static int gcf(int numbah1, int numbah2) {
		int factor;
		for(factor = numbah1; !(isDivisibleBy(numbah1,factor)&&(isDivisibleBy(numbah2,factor))) ; factor--) {
		}
		return factor;
	}
	//This method returns an approximation of the square root of a given double.
	public static double sqrt(double numbah) {
		double A = numbah/2;
		double root = 0;
		while(root != (numbah / A + A)/2) {
			root = (numbah / A + A)/2;
			A= root;
		}
		return round2(root);
	}
	
}