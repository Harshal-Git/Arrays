/**
 * 
 */
package com.findPairWithGivenSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 * -> Find pairs of elements with given sum.
 *	
 *	Approach:  If given array is sorted then this is the best solution.
 *	
 *			Algo: create pointers: start, end
 *
 *				  if(data at start + data at end) == sum
 *						return pair;
 *						start++;
 *						end--;
 *				  else if (data at start + data at end) < sum
 *						start++;
 *				  else 
 *						end--;
 *
 * -> Drawback: It can return the same element paired with itself. (if any sum is given like that).
 *
 * -> Time complexity:  O(n Log n) - for sorting (based on sorting algo)
 * 					  + O(n) - for two pointer traversal of array
 * 				Total: O(n) + O(n Log n) ~ O(n Log n) : considering highest term 
 * 				(a marginal difference between O(n Log n) & O(n) : for lower values of n.) 
 * -> Space complexity: O(n) - ignoring string builder variable (used only for data population); separate array used for sorting
 * -> Auxiliary space: O(1) 
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
		Arrays.sort(data);
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
		boolean pairsFound = false;
		// input validation
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array. ");
		}
		if(data.length == 1) {
			pairsFound = false;
		} else {

			// get 2 pointers and find pair having given sum
			int start = 0;
			int end = (data.length-1);

			while(start <= end) {
				if(((data[start]+data[end]) == sum) && (data[start] != data[end])) {
					// if pair found
					pairs.append(data[start]).append(" : ").append(data[end]).append(", ");
					start++;
					end--;
					pairsFound= true;
				} else if((data[start]+data[end]) < sum) {
					// if sum is found lower than the given pair, move start pointer to next position
					start++;
				} else {
					// if sum is higher than the given pair, move end pointer to previous position
					end--;
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
