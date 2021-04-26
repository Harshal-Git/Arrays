/**
 * 
 */
package com.rotated.findSumOfPair;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	Find pairs of elements with given sum.
 *	
 *	Approach: Basic approach : comparing each element with it's own & all remaining elements on it's right. 
 *
 *	Assumptions: No need of sorted array, no cautions about repeated elements. 
 *
 * -> Time complexity: O(n^2) - linear search twice for the given array  .
 *
 * -> Space complexity: O(1) - ignoring string builder variable (used only for data population); has no other additional data structure.
 *
 * -> This algo won't return same element pairing (if any).
 */
public class FindSumPairAp1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		runCase(new int[] {0, -1, 2, -3, 1}, -2);

		// case 2
		runCase(new int[] {1, 4, 45, 6, 10, -8}, 16);

		// case 3
		runCase(new int[] {1, -2, 1, 0, 5}, 0);
	}

	/**
	 * method to run case
	 * @param data - array data
	 * @param sum - sum for which pairs to be found 
	 */
	private static void runCase(int[] data, int sum) {
		StringBuilder pairs = new StringBuilder();
		boolean pairsFound = findSumPairs(data, sum, pairs);
		if(pairsFound) {
			System.out.println("Array: "+Arrays.toString(data)+" has pair/s: ("+pairs.toString()+") which has sum: "+sum+".");
		} else {
			System.out.println("No pair found in array: "+Arrays.toString(data)+" which has sum: "+sum+".");
		}
	}

	/**
	 * method to find pairs having given sum
	 * @param data - array data
	 * @param sum - sum to found
	 * @param pairs - string builder to collect pairs (if found)
	 * @return - boolean status whether pairs are found OR not
	 */
	private static boolean findSumPairs(int[] data, int sum, StringBuilder pairs) {
		boolean pairsFound = false;
		// input validation
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array. ");
		}
		if(data.length == 1) {
			pairsFound = false;
		} else {
			int length = data.length;
			// iterate over complete array for each element 
			// to check what all combinations of other elements can make given sum
			for(int indexOne = 0; indexOne < length; indexOne++) {
				// pair with element it self cannot be considered
				for(int indexTwo = (indexOne+1); indexTwo < length; indexTwo++) {
					if((data[indexOne]+data[indexTwo]) == sum) {
						pairsFound = true;
						pairs.append(data[indexOne]).append(" : ").append(data[indexTwo]).append(", ");
					}
				}
			}
		}
		// if some data is present, format it
		if(pairs.length() > 0) {
			int length = pairs.length();
			pairs.delete((length-2), length);
		}
		return pairsFound;
	}
}
