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
 *	-> Approach: Temp array method (Left shift)
 *
 *		for(A.index) {
 *			if(index >= d) {
 *				newPosition = (index - d);
 *			} else {
 *				newPosition = n + (index - d);
 *			}
 *			B[newPosition] = A[index];
 *		}
 * 
 *	-> Time complexity: O(n)	: O(n) - for new position calculation & putting data into temp array   
 *								+ O(n) - to put elements from temp to original array 
 *					   --> Total= O(2n) ~ O(n) - ignoring constants
 *	-> Space complexity: O(n) - additional array of the same size as actual array; ignoring some variables
 *								used to calculate new index
 *	-> Auxiliary space : 0(n)
 */
public class RotationByTempArrayLS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* input 1 */
		int arr1[] = new int[] {1, 2, 3, 4, 5, 6};
		int rotatePosition1 = 6;
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
	 * rotate given array to left by given position
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

			// new array
			int [] newArr = new int [n];

			// calculate position in new array and put elements directly from old array
			/*
			 * shift left might result in new indexes in lesser than 0; and it will never be greater 
			 * than the array size; hence module operation might not be needed.
			 */
			for(int index = 0; index < n; index++) {
				if(index >= rotatePos) {
					newArr[index-rotatePos] = arr[index];
				} else {
					newArr[(n)+(index-rotatePos)] = arr[index];
				}
			}
			// save elements from new array back to original array
			for(int index = 0; index < newArr.length; index++) {
				arr[index] = newArr[index];
			}
		}
	}
}
