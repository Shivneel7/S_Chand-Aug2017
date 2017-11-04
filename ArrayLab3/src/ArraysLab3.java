//Shivneel Chand
//11-1-17
//Arrays Lab 3

import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		int[] a1 = {5,10,15,20,25,30,35,40};
		int[] a2 = {7,14,21,28,35,42,49,56};
		int[] sumArr = sum(a1,a2);
		int appendNum = 200;
		int [] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
		
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
	
	public static int[] remove(int[] arr, int idx) {
		int[] result = new int[arr.length-1];
		for(int i = 0; i < idx; i++) {
			result[i] = arr[i];
		}
		for(int i=idx; i < result.length; i++) {
			result[i] = arr[i+1];
		}
		return result;
	}
// returns the sum of the values at even indices
	public static int sumEven(int [] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i+=2) {
			sum += arr[i];
		}
		return sum;
	}

	public static void rotateRight(int[] arr) {
		int last = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = last;
	}

}





