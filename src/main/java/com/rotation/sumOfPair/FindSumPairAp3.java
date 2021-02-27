/**
 * 
 */
package com.rotation.sumOfPair;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Harshal-Git
 *
 *	Find pairs of elements with given sum.
 *	
 *	Approach:  Hashing method
 *	
 *	Algo: For each element from given array {
 *			find remainder for each element (sum - array[index] element)
 *			if this remainder does not exist in the hash data structure; insert into it
 *			otherwise return the array[index] element & remainder as required pair
 *		  }
 *
 * -> Time complexity: 	  O(n) - to iterate over all array elements
 * 						+ O(1) - to insert / check whether element exist in hash data structure
 * 				   Total: O(n) - considering iteration over all elements once
 *
 * -> Space complexity: O(n) - for preparing a hash data structure
 *
 * -> This algo won't return same element pairing (if any).
 */
public class FindSumPairAp3 {

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
		// hash data structure to store elements
		HashSet<Integer> elementsSet = new HashSet<>();
		boolean pairsFound = false;
		// input validation
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array. ");
		}
		if(data.length == 1) {
			pairsFound = false;
		} else {
			// iterate over all elements of given array
			for(int index = 0; index < data.length; index++) {
				// find remainder which should be there in hash data structure
				int remainderToCheck = sum - data[index];
				// if remainder exist in hash data structure; pair found
				if(elementsSet.contains(remainderToCheck)) {
					// if pair found
					pairs.append(data[index]).append(" : ").append(remainderToCheck).append(", ");
					pairsFound = true;
				} else {
					elementsSet.add(data[index]);
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
