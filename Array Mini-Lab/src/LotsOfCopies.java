//Shivneel Chand
//11-1-17
import java.util.Arrays;
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1,2,3,4,5};
		changeMe(num, strMain, arrMain);
		System.out.println(num + "  " + strMain + "  " + Arrays.toString(arrMain));
		//the only one that changed was the array.
		
		
		//testing changing ints
		int a = 4;
		int b = a;
		a = 1234;
		System.out.println(b);
		//testing Strings
		String stringA = "Original stringA";
		String stringB = stringA;
		stringA = "New stringA";
		System.out.println(stringB);
		//testing arrays
		int[] arrA = {1,23,4,};
		int[] arrB = arrA;
		arrA[0] = 89;
		System.out.println(Arrays.toString(arrB));
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x=23;
		str = "new String";
		arr[2] = 97;
	}
}
