/**
 * 
 */
package com.slidingWindow.subArrayExistWithGivenSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> an array with non-negative integer and a sum are given. Find whether any sun array exist with given sum? (Yes/No)
 *
 * 	-> using sliding window technique
 * 
 * 	ex:
 * 		i/p: {1, 4, 20, 3, 10, 5} & sum = 33 	=> o/p: Yes
 * 
 * 		i/p: {1, 4, 0, 0, 3, 10, 5} & sum = 7 	=> o/p: Yes
 * 
 * 		i/p: {2, 4} & sum = 3 					=> o/p: No
 * 
 * 	-> base line : this will only work for NON-NEGATIVE integer.
 * 
 * -> Time complexity:	O(n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class FindSubArrayExistEfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int sum;

		int [] data1 = {1, 4, 20, 3, 10, 5};
		sum = 32;
		printMessage(data1, sum);

		int [] data2 = {1, 4, 20, 3, 10, 5};
		sum = 33;
		printMessage(data2, sum);

		int [] data3 = {1, 4, 0, 0, 3, 10, 5};
		sum = 7;
		printMessage(data3, sum);

		int [] data4 = {2, 4};
		sum = 3;
		printMessage(data4, sum);

		int [] data5 = {5, 8, 3};
		sum = 16;
		printMessage(data5, sum);

	}

	/**
	 * @param data1
	 * @param sum
	 */
	private static void printMessage(int[] data, int sum) {
		System.out.println("\nIs a sub array in "+Arrays.toString(data)+" present with sum = "+sum
				+" ? : "+findSumPresent(data, sum));
	}

	/**
	 * @param data1
	 * @param sum
	 * @return
	 */
	private static String findSumPresent(int[] data, int sum) {

		// initializations
		int size = data.length;
		int windowSum = 0;
		int deleteIndex = 0;
		int startIndex = 0;

		// iterate over all elements and check whether we can find sum as asked?
		while(startIndex < size) {

			// if window sum is smaller than sum
			if(windowSum < sum) {
				windowSum += data[startIndex++];
			} else if (windowSum > sum){
				// if window sum is higher than sum : delete element from initial position
				windowSum -= data[deleteIndex++];
			} else {
				// if we found required sum
				return "Yes";
			}
		}
		// this condition is needed when sum of all elements is 
		// the expected sum (no subtraction has happened)
		if(windowSum == sum) {
			return "Yes";
		} else {
			// if we don't find required sum
			return "No";
		}
	}

}
