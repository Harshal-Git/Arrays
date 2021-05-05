/**
 * 
 */
package com.slidingWindowTech;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> given an array of integers & a number 'k'. find maximum sum of 'k' consecutive elements.
 *
 *	-> efficient approach : first find sum of 'k' elements. Then in linear manner, remove first element & add next 
 *							element to find sum of next 'k' elements; continue until max sum is found. 
 *
 *	ex:
 *
 *		i/p: {1, 8, 30, -5, 20, 7} & k = 3	=> o/p : 45 (1+8+30)
 *
 *		i/p: {5, -10, 6, 90, 3} & k = 2	=> o/p : 96 (6+90)
 *
 * -> Time complexity:	0(k) + 0(n-k) ~ 0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class PrintMaxSumAP2 {

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
		int firstWindowSum = 0;
		int size = data.length;

		// find first 'k' elements sum
		for(int index = 0; index < k; index++) {
			firstWindowSum += data[index];
		}

		// define max sum from first window sum
		int maxSum = firstWindowSum;
		
		// start adding & subtracting remaining elements and keep 
		// shifting window towards right & finding maximum sum
		for(int index = k; index < size; index++) {
			firstWindowSum += (data[index] - (data[index-k]));
			maxSum = findMax(maxSum, firstWindowSum);
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
