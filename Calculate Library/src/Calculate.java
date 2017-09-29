//Shivneel Chand
//September 6th 2017
//My self written math library 
//It contains a series of methods to do basic math functions.
public class Calculate {	
	//returns the square of the given int
	public static int square(int numbah) {
		return numbah * numbah;
	}
	// returns the cube of the given int 
	public static int cube(int numbah) {
		return numbah * numbah * numbah;
	}
	//returns the average of two doubles
	public static double average(double numbah1, double numbah2) {
		return (numbah1 + numbah2)/2;
	}
	//returns the average of three doubles
	public static double average(double numbah1, double numbah2, double numbah3) {
		return (numbah1 + numbah2 + numbah3) / 3;
	}
	//returns the degree form of a given radian
	public static double toDegrees(double numbah) {
		return (numbah/3.14159 * 180);
	}
	//returns the radian form of a given double
	public static double toRadians(double numbah) {
		return ((numbah *3.14159) / 180);
	}
	//returns the discriminant of a quadratic equation given the coefficients a, b, and c
	public static double discriminant(double a, double b, double c) {
		return (b*b - (4*a*c));
	}
	//returns the Improper fraction form of a given mixed number
	public static String toImproperFrac(int wholeNumbah, int numerator, int denominator) {
		int newNumerator = wholeNumbah * denominator + numerator;
		return (newNumerator + "/" + denominator);
	}
	//returns the mixed number form of a given improper fraction
	public static String toMixedNum(int numerator, int denominator) {
		int wholeNumbah = numerator/denominator;
		int newNumerator = numerator%denominator;
		return (wholeNumbah + "_" + newNumerator + "/" + denominator);
	}
	//accepts the coefficients  of a binomial, and multiplies them into a quadratic equation
	public static String foil(int a, int b, int c, int d, String variable) {
		int middleNumber = b*c + a* d;
		return (a*c + variable + "^2 + " + middleNumber + variable + " + " + b*d);
	}
	// accepts two integers and returns true if the first number is evenly divisible by the second, and false if there is a remainder.
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("Cannot divide by 0.");
		}
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
	//takes two doubles and returns the larger value
	public static double max(double numbah1, double numbah2) {
		if(numbah1<numbah2) {
			return numbah2;
		}else {
			return numbah1;
		}
	}
	//takes three doubles, and returns the largest value
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
	//Takes two doubles and returns the lower double.
	public static double min(double numbah1, double numbah2) {
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
	//Takes one double and one positive integer, and raises the double to the power of the integer.
	public static double exponent(double base, int exponent) {
		if(exponent < 0) {
			throw new IllegalArgumentException("Cannot find a number raised to a negative value.");
		}
		double result = base;
		if(exponent == 0) {
			return 1;
		}
		for(int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	//Returns the factorial of the value passed
	public static int factorial(int numbah) {
		if(numbah<0) {
			throw new IllegalArgumentException("Cannot calculate factorial of negative number!");
		}
		int result = 1;
		for(int i = 1; i <= numbah; i++) {
			result*= i;
		}
		return result;
	}
	//returns true or false based on whether the number given is prime or not.
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
	//This method takes two integers and returns the greatest common factor of the two integers
	public static int gcf(int numbah1, int numbah2) {
		int factor;
		for(factor = numbah1; !(isDivisibleBy(numbah1,factor)&&(isDivisibleBy(numbah2,factor))) ; factor--) {
		}
		return factor;
	}
	//This method returns an approximation of the square root of a given double.
	public static double sqrt(double numbah) {
		if(numbah < 0 ) {
			throw new IllegalArgumentException("Cannot find squareroot of negative number.");
		}
		if(numbah == 0) {//So that the program does not break from dividing by 0.
			return 0;
		}
		double A = numbah/2;
		double root = 0;
		while(root != (numbah / A + A)/2) {//This while loop will stop when the computer is not able to tell the difference 
			root = (numbah / A + A)/2;		//between this approximate root, and the previous approximation.
			A= root;
		}
		return round2(root);
	}
	//This method returns the roots of a quadratic equation given the coefficients of the quadratic equation.
	public static String quadForm(int a, int b, int c) {
		double disc = discriminant(a,b,c);
		if(disc<0) {
			return "no real roots";
		}
		if(disc == 0) {
			double root = (-1*b + sqrt(disc))/2*a;
			return round2(root) + ""; //Converts root from a double to a String.
		}else {
			double root1 = round2((-1*b + sqrt(disc))/2*a);
			double root2 = round2((-1*b - sqrt(disc))/2*a);
			if(min(root1,root2) == root1) {
				return root1 + " and " + root2;
			}else {
				return root2 + " and " + root1;
			}
		}
	}
}