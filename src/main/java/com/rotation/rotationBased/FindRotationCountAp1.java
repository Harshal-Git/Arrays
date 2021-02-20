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
 *	Approach 1: Linear search. While iterating the array; at any time if a(i) > a(i+1); that is rotation count.	
 *				OR in other words; find index of lowest element.
 *
 *	-> Time complexity: O(n) - linear search for lowest element in the given array  
 *
 *	-> Space complexity: O(1) - apart from 2 variables; no other data structures are used.
 */
public class FindRotationCountAp1 {

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
		runCase(new int[] {4, 3, 2, 1});
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

		// find lowest element index
		int minIndex = -1;
		int minElement = -1;

		// if data is null
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array.");
		}

		// length validation
		int length = data.length;

		// if only one element exist OR array is not rotated at all
		if(length == 1 || (data[0] < data[length-1])) {
			return 0;
		}
		// for every other case
		else {
			minElement = data[0];
			for(int index = 1; index < length; index++) {
				// find index lowest element
				if(minElement > data[index]) {
					minElement = data[index];
					minIndex = index;
				}
			}
		}
		return minIndex;
	}
}