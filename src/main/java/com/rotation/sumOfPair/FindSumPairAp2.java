/**
 * 
 */
package com.rotation.sumOfPair;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	Find pairs of elements with given sum.
 *	
 *	Approach:  Sort given array & then using 2 pointer methods
 *	
 *			Algo: Sort(array);
 *
 *				  create pointers: start, end
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
 *
 * -> Space complexity: O(n) - ignoring string builder variable (used only for data population); separate array used for sorting
 *
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
		runCase(new int[] {1, -2, 1, 0, 5}, 4);
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
			// sort given array
			Arrays.sort(data);
			
			// get 2 pointers and find pair having given sum
			int start = 0;
			int end = (data.length-1);
			
			while(start <= end) {
				if((data[start]+data[end]) == sum) {
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
