//Does math
public class DoMath {
//This is the runner for the calculate library. It is used to test the Calculate Library.
	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(5,6));
		System.out.println(Calculate.average(5,6,7));
		System.out.println(Calculate.toDegrees(6.28));
		System.out.println(Calculate.toRadians(90));
		System.out.println(Calculate.toRadians(90));
		System.out.println(Calculate.discriminant(7, 2, -3));
		System.out.println(Calculate.toImproperFrac(4,7,8));
		System.out.println(Calculate.toMixedNum(39,8));
		System.out.println(Calculate.foil(2,3,6,-7, "n"));
		System.out.println(Calculate.isDivisibleBy(4,2));
		System.out.println(Calculate.absValue(-7));
		System.out.println(Calculate.max(11,7, 11));
		System.out.println(Calculate.min(-14,-12));
		System.out.println(Calculate.round2(1031.6249343));
		System.out.println(Calculate.exponent(3, 4));
		System.out.println(Calculate.factorial(7));
		System.out.println(Calculate.isPrime(9));
		System.out.println(Calculate.gcf(16,1234));
		System.out.println(Calculate.sqrt());
	}
}