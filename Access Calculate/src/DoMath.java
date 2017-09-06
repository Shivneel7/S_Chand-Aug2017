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
		System.out.println();
	}
}