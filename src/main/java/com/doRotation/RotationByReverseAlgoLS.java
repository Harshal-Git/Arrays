/**
 * 
 */
package com.doRotation;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> a function rotate(array, d, n) to rotate the given array to left
 *	
 *		array: array to be rotated
 *		d: rotate positions (some positive value)
 *		n: array length
 *
 *	-> Approach: Reverse array method (for left shift only)
 *		
 *		reverse(A, 0, (d-1)) : reverse partial array from 0 --> (d-1)
 *		reverse(A, d, (n-1)) : reverse partial array from d --> (n-1)
 *		reverse(A, 0, (n-1)) : reverse complete array from 0 --> (n-1) 
 *
 *	-> Time complexity: O(n)	: O(d-1)       ~ O(n) - for 0 --> (d-1)   
 *								+ O((n-1) - d) ~ O(n) - for d --> (n-1)
 *								+ O(n-1)       ~ O(n) - for 0 --> (n-1) 
 *					   --> Total= O(3n) 	   ~ O(n) - ignoring constants
 *	-> Space complexity: O(1) - considering additional int variables are used; their assignments 
 *								taking constant time & input array is not being considered.
 *	-> Auxiliary space : 0(1)
 */
public class RotationByReverseAlgoLS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] arr = null;
		int rotatePos = -1;

		/* input 1 */
		arr = new int[] {1, 2, 3, 4, 5};
		rotatePos = 2;
		printMessage(arr, rotatePos);

		/* input 2 */
		arr = new int[] {2, 6, 10, 8, 4};
		rotatePos = 9;
		printMessage(arr, rotatePos);
	}

	/**
	 * @param arr
	 * @param rotatePos
	 */
	private static void printMessage(int[] arr, int rotatePos) {
		System.out.println("Array: "+Arrays.toString(arr));
		System.out.println("Left Rotate position: "+rotatePos);
		rotate(arr, rotatePos);
		System.out.println("Rotated array: "+Arrays.toString(arr)+"\n");		
	}

	/**
	 * rotate given array to left by given position
	 * @param arr - array
	 * @param d - shift positions
	 * @param n - array length (don't adjust to n-1)
	 */
	private static void rotate(int [] arr, int d) {
		// size of the array
		int size = arr.length;

		// calculate new rotate position 
		// (considering rotate position bigger value than array length)
		int rotatePos = (d % size);

		// if no rotation is needed; don't do it
		if(rotatePos != 0) {
			// reverse A(0, d-1)
			reverse(arr, 0, (rotatePos-1));
			// reverse A(d, n-1)
			reverse(arr, rotatePos, (size-1));
			// reverse A(0, n-1)
			reverse(arr, 0, (size-1));			
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