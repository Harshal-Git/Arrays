/**
 * 
 */
package com.findPairWithGivenSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Harshal-Git
 *
 *	Find pairs of elements with given sum.
 *	
 *	Approach:  Hashing method : if given array is not sorted, then this is best solution considering additional
 *				space for hash DS.
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
 * -> Space complexity: O(n) - for preparing a hash data structure
 * -> Auxiliary space: O(n) - for preparing a hash data structure
 * 
 * -> This algo won't return same element pairing (if any).
 */
public class FindSumPairAp2 {

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
		
		// case 4
		runCase(new int[] {3, 5, 9, 2, 8, 10, 11}, 17);
		
		// case 5
		runCase(new int[] {8, 4, 6}, 11);
		
		// case 6
		runCase(new int[] {2, 5, 8, 12, 30}, 17);
		
		// case 7
		runCase(new int[] {3, 8, 13, 18}, 14);
		
		// case 8
		runCase(new int[] {2, 4, 8, 9, 11, 12, 20, 30}, 23);
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
			System.out.println("\nArray: "+Arrays.toString(data)+" has pair/s: ("+pairs.toString()+") which has sum: "+sum+".");
		} else {
			System.out.println("\nNo pair found in array: "+Arrays.toString(data)+" which has sum: "+sum+".");
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
		Set<Integer> elementsSet = new HashSet<>();
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
