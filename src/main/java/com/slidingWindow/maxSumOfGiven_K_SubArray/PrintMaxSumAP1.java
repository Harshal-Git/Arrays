/**
 * 
 */
package com.slidingWindow.maxSumOfGiven_K_SubArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> given an array of integers & a number 'k'. find maximum sum of 'k' consecutive elements.
 *
 *	-> naive approach : for each element, find sum of elements starting from that element till 'k'. And keep record
 *						of such sum to find max sum.
 *
 *	ex:
 *
 *		i/p: {1, 8, 30, -5, 20, 7} & k = 3	=> o/p : 45 (1+8+30)
 *
 *		i/p: {5, -10, 6, 90, 3} & k = 2	=> o/p : 96 (6+90)
 *
 * -> Time complexity:	O(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class PrintMaxSumAP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int k;

		int [] data1 = {1, 8, 30, -5, 20, 7};
		k = 3;
		printMaxSum(data1, k);

		int [] data2 = {5, -10, 6, 90, 3};
		k = 2;
		printMaxSum(data2, k);

	}

	/**
	 * @param data
	 * @param k
	 */
	private static void printMaxSum(int[] data, int k) {
		System.out.println("\nArray: "+Arrays.toString(data)+" -> Max sum of "+k
				+" consecutive elements: "+findMaxConsecutiveSum(data, k));		
	}

	/**
	 * @param data
	 * @param k
	 * @return
	 */
	private static int findMaxConsecutiveSum(int[] data, int k) {
		
		// initial elements
		int maxSum = data[0];
		int subArraySum = data[0];
		
		int size = data.length;
		int consecutiveCount = 0;

		// for each element: 
		for(int index = 0; index < (size-(k-1)); index++) {

			// reset values for new sub array
			consecutiveCount = 0;
			subArraySum = 0;

			// calculate sum of (i+k) elements for current index
			while(consecutiveCount < k) {
				subArraySum += data[(index+consecutiveCount)];
				consecutiveCount++;
			}

			// find max of previous sum & current sub array sum
			maxSum = findMax(maxSum, subArraySum);
		}
		return maxSum;
	}

	/**
	 * @param maxSum
	 * @param subArraySum
	 * @return
	 */
	private static int findMax(int num1, int num2) {
		return ((num1 > num2) ? (num1) : (num2));
	}
}
