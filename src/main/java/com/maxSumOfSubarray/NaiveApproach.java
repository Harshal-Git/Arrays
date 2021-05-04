/**
 * 
 */
package com.maxSumOfSubarray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find max sum of sub arrays
 *
 *	-> base line: sub array - all possible combination of consecutive elements 
 *
 *		ex: sub array of {1, 2, 3} => {1}, {2}, {3}, {1, 2}, {2, 3}, {1, 2, 3} [{1, 3} cannot be sub array as they are not consecutive]
 *
 *	ex: 
 *		i/p = {2, 3, -8, 7, -1, 2, 3}	=> o/p = 11
 *
 *		i/p = {5, 8, 3}	=> o/p = 16
 *
 *		i/p = {1, 2}	=> o/p = 3
 *
 *		i/p = {-6, -1, -8}	=> o/p = -1
 *
 *	-> naive approach : find max sum out of all possible sub arrays
 *
 * -> Time complexity:	0(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 2};
		System.out.println("Array: "+Arrays.toString(data1)+" --> Max sub array sum = "+findMaxSubArraySum(data1));

		int [] data2 = {5, 8, 3};
		System.out.println("\nArray: "+Arrays.toString(data2)+" --> Max sub array sum = "+findMaxSubArraySum(data2));

		int [] data3 = {2, 3, -8, 7, -1, 2, 3};
		System.out.println("\nArray: "+Arrays.toString(data3)+" --> Max sub array sum = "+findMaxSubArraySum(data3));

		int [] data4 = {-6, -1, -8};
		System.out.println("\nArray: "+Arrays.toString(data4)+" --> Max sub array sum = "+findMaxSubArraySum(data4));
		
		int [] data5 = {1, -2, 3, -1, 2};
		System.out.println("\nArray: "+Arrays.toString(data5)+" --> Max sub array sum = "+findMaxSubArraySum(data5));
		
		int [] data6 = {-5, 1, -2, 3, -1, 2, -2};
		System.out.println("\nArray: "+Arrays.toString(data6)+" --> Max sub array sum = "+findMaxSubArraySum(data6));
		
		int [] data7 = {-3, 8, -2, 4, -5, 6};
		System.out.println("\nArray: "+Arrays.toString(data7)+" --> Max sub array sum = "+findMaxSubArraySum(data7));
	}

	/**
	 * @param data - array data
	 * @return
	 */
	private static int findMaxSubArraySum(int[] data) {

		// need to take first element as initial value so it will not fail
		// for all negative value integers
		int maxSum = data[0];

		// find size
		int size = data.length;

		// initialize sum for all sub array
		int tempSum = 0;

		// iterate over all elements and for each element, find max sum of sub arrays
		for(int index = 0; index < size; index++) {
			// reset temp sum
			tempSum = 0;

			// find sum of all sub array
			for(int count = index; count < size; count++) {
				tempSum += data[count];

				// compare sum of sub elements with any previously found max sum
				if(maxSum < tempSum) {
					maxSum = tempSum;
				}
			}
		}
		return maxSum;
	}

}
