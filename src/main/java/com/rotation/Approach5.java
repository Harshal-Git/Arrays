/**
 * 
 */
package com.rotation;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 * -> a function rotate(array, d, n) to shift given array to right
 *	
 *		array: array to be rotated
 *		d: rotate positions (some positive value)
 *		n: array length
 *
 *	-> Approach: Shift one position to right : d times
 *
 *  -> Time complexity: O(n^2)	: O(d) - for calling single shift d times   
 *								* O(n) - perform single shift 
 *					   --> Total= O(d * n) ~ O(n^2) - taking highest range
 *
 *	-> Space complexity: O(1) - few variables to register first / last element; hence ignoring those.
 *
 */
public class Approach5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* input 1 */
		int arr1[] = new int[] {1, 2, 3, 4, 5, 6};
		int rotatePosition1 = 4;
		System.out.println("Array: "+Arrays.toString(arr1));
		System.out.println("Rotate position: "+rotatePosition1);
		rotate(arr1, rotatePosition1, arr1.length);
		System.out.println("Rotated array: "+Arrays.toString(arr1)+"\n");
	
		/* input 2 */
		int arr2[] = new int[] {2, 6, 10, 8, 4};
		int rotatePosition2 = 13;
		System.out.println("Array: "+Arrays.toString(arr2));
		System.out.println("Rotate position: "+rotatePosition2);
		rotate(arr2, rotatePosition2, arr2.length);
		System.out.println("Rotated array: "+Arrays.toString(arr2)+"\n");
	}
	
	/**
	 * rotate given array to right by given position
	 * @param arr - array
	 * @param d - shift positions
	 * @param n - array length (don't adjust to n-1)
	 */
	private static void rotate(int [] arr, int d, int n) {
		
		// calculate new rotate position 
		// (considering rotate position bigger value than array length)
		int rotatePos = (d % n);
		
		// rotate given array by 1 position to right for "rotatePos" times
		for(int count = 1; count <= rotatePos; count++) {
			shiftSinglePosition(arr, n);
		}
	}
	
	/**
	 * method to shift given array to one position right side
	 * @param arr - array data
	 * @param length - length of the array
	 */
	private static void shiftSinglePosition(int [] arr, int length) {
		int lastElement = arr[length-1];
		for(int index = (length-2); index >= 0; index--) {
			arr[index+1] = arr[index];
		}
		arr[0] = lastElement;
	}
}
