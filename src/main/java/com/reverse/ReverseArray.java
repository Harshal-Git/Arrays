/**
 * 
 */
package com.reverse;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Reverse a given array
 *
 *	-> Time complexity: O(n) - while loop (though it will run only till half way (n/2) of the array; ignoring the constant divisor)
 *
 *	-> Space complexity: O(1) - considering 3 additional int variables are used; their assignments 
 *								taking constant time & input array is not being considered.
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* input 1 */
		int arr1[] = new int[] {1, 3, 5, 7, 9, 11};
		System.out.println("Array: "+Arrays.toString(arr1));
		reverse(arr1, 0, (arr1.length-1));
		System.out.println("Reversed array: "+Arrays.toString(arr1)+"\n");

		/* input 2 */
		int arr2[] = new int[] {2, 6, 10, 8, 4};
		System.out.println("Array: "+Arrays.toString(arr2));
		reverse(arr2, 0, (arr2.length-1));
		System.out.println("Reversed array: "+Arrays.toString(arr2)+"\n");

		/* input 3 */
		int arr3[] = new int[] {12, 17};
		System.out.println("Array: "+Arrays.toString(arr3));
		reverse(arr3, 0, (arr3.length-1));
		System.out.println("Reversed array: "+Arrays.toString(arr3)+"\n");
	}

	/**
	 * method to reverse a given array
	 * @param arr - array data
	 * @param start - start position
	 * @param end - end position
	 */
	private static void reverse(int[] arr, int start, int end) {
		int startPos = start;
		int endPos = end;
		while(startPos <= endPos) {
			int temp = arr[endPos];
			arr[endPos] = arr[startPos];
			arr[startPos] = temp;
			startPos++;
			endPos--;
		}
	}
}
