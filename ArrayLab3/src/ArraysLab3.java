import java.util.Arrays;

//Shivneel Chand
//11-1-17
//Arrays Lab 3
public class ArraysLab3 {

	public static void main(String[] args) {
		int[] a1 = {1,1,1,1};
		int[] a2 = {6,6,6,6};
		System.out.println(Arrays.toString(sum(a1,a2)));
		
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] sum = new int[arr1.length];
		for(int i = 0; i < arr1.length;i++) {
			sum[i] = arr1[i]+arr2[i];
		}
		return sum;
	}
	
	public static int[] append(int[] arr,int num) {
		int[] newArr = new int[arr.length+1];
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = num;
		return newArr;
	}


}
