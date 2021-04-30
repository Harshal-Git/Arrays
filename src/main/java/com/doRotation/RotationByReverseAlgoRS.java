/**
 * 
 */
package com.doRotation;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> a function rotate(array, d, n) to rotate the given array to right 
 *	
 *		array: array to be rotated
 *		d: rotate positions (some positive value)
 *		n: array length
 *
 *	-> Approach: Reverse array method (for right shift only)
 *		
 *		reverse(A, 0, (n-1)) : reverse complete array from 0 --> (n-1)
 *		reverse(A, 0, (d-1)) : reverse partial array from 0 --> (d-1)
 *		reverse(A, d, (n-1)) : reverse partial array from d --> (n-1)
 *
 *	-> Time complexity: O(n)	: O(n-1)       ~ O(n) - for 0 --> (n-1)
 *								+ O(d-1)       ~ O(n) - for 0 --> (d-1)   
 *								+ O((n-1) - d) ~ O(n) - for d --> (n-1) 
 *					   --> Total= O(3n) 	   ~ O(n) - ignoring constants
 *
 *	-> Space complexity: O(1) - considering additional int variables are used; their assignments 
 *								taking constant time & input array is not being considered.
 *
 *	-> Auxiliary space : 0(1)
 */
public class RotationByReverseAlgoRS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* input 1 */
		int arr1[] = new int[] {1, 2, 3, 4, 5};
		int rotatePosition1 = 2;
		System.out.println("Array: "+Arrays.toString(arr1));
		System.out.println("Rotate position: "+rotatePosition1);
		rotate(arr1, rotatePosition1, arr1.length);
		System.out.println("Rotated array: "+Arrays.toString(arr1)+"\n");

		/* input 2 */
		int arr2[] = new int[] {2, 6, 10, 8, 4};
		int rotatePosition2 = 9;
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

		// if no rotation is needed; don't do it
		if(rotatePos != 0) {
			// reverse A(0, n-1)
			reverse(arr, 0, (n-1));
			// reverse A(0, d-1)
			reverse(arr, 0, (rotatePos-1));
			// reverse A(d, n-1)
			reverse(arr, rotatePos, (n-1));
		}
	}

	/*
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