/**
 * 
 */
package com.reverseArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Reverse a given array
 *
 *	-> Time complexity: 0(n/2) ~ 0(n) 
 *	-> Space complexity: 0(n) 
 *	-> Auxiliary space: 0(1) 
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] arr1 = {1, 3, 5, 7, 9, 11};
		System.out.println("Array: "+Arrays.toString(arr1));
		reverse(arr1);
		System.out.println("Reversed array: "+Arrays.toString(arr1)+"\n");

		int [] arr2 = {2, 6, 10, 8, 4};
		System.out.println("Array: "+Arrays.toString(arr2));
		reverse(arr2);
		System.out.println("Reversed array: "+Arrays.toString(arr2)+"\n");

		int [] arr3 = {12, 17};
		System.out.println("Array: "+Arrays.toString(arr3));
		reverse(arr3);
		System.out.println("Reversed array: "+Arrays.toString(arr3)+"\n");
		
		int [] arr4 = {10, 5, 7, 30};
		System.out.println("Array: "+Arrays.toString(arr4));
		reverse(arr4);
		System.out.println("Reversed array: "+Arrays.toString(arr4)+"\n");
		
		int [] arr5 = {30, 20, 5};
		System.out.println("Array: "+Arrays.toString(arr5));
		reverse(arr5);
		System.out.println("Reversed array: "+Arrays.toString(arr5)+"\n");
	}

	/**
	 * method to reverse a given array
	 * @param arr - array data
	 * @param start - start position
	 * @param end - end position
	 */
	private static void reverse(int[] arr) {
		int startPos = 0;
		int endPos = (arr.length-1);
		int temp;
		while(startPos < endPos) {
			temp = arr[endPos];
			arr[endPos] = arr[startPos];
			arr[startPos] = temp;
			startPos++;
			endPos--;
		}
	}
}
