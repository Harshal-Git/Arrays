/**
 * 
 */
package com.rotation.rotationBased;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	Assumptions:
 *	An array of distinct numbers, sorted in increasing order. The array has been rotated (clockwise - right shifted) k number of times.
 *	Find that 'k'.
 *
 * This approach might not give proper results with fully reverse sorted elements.
 *
 *	Approach 2: Binary search. 
 *
 *	-> Time complexity: [NEED TO CALCULATE]  
 *
 *	-> Space complexity: [NEED TO CALCULATE]
 */
public class FindRotationCountAp2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		runCase(new int[] {15, 18, 2, 3, 6, 12});

		// case 2
		runCase(new int[] {7, 9, 11, 12, 5});

		// case 3
		runCase(new int[] {7, 9, 11, 12, 15});

		// case 4
		runCase(new int[] {1, 2});
	}

	/**
	 * print results
	 * @param data - array data
	 */
	private static void runCase(int [] data) {
		// get rotation count
		System.out.println("Data: "+Arrays.toString(data)+" -> Rotation count: "+findRotationCount(data));
	}

	/**
	 * method to find rotation count in given array
	 * @param data - int array
	 * @return rotation count of given array
	 */
	private static int findRotationCount(int[] data) {
		// if data is null
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array.");
		}

		// length validation
		int length = data.length;

		// if only one element exist OR array is not rotated at all
		if(length == 1 || (data[0] < data[length-1])) {
			return 0;
		} else {
			return findRotation(data, 0, (length-1));
		}
	}

	/**
	 * @param data - array data
	 * @param start - start position of the array
	 * @param end - end position of the array
	 * @return - returns rotation count of given array
	 */
	private static int findRotation(int[] data, int start, int end) {
		// calculate mid position
		int mid = start + ((end - start)/2);

		// check if 'mid' is lowest element 
		if(data[mid] < data[mid-1]) {
			return mid;
		}
		// check if 'mid+1' is lowest element
		if(data[mid+1] < data[mid]) {
			return (mid+1);
		}
		// decide whether to go for left OR right portion
		if(data[mid] < data[end]) {
			return findRotation(data, start, mid-1);
		} else {
			return findRotation(data, mid+1, end);
		}
	}
}