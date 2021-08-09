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
 *		ex: sub array of {1, 2, 3} => {1}, {2}, {3}, {1, 2}, {2, 3}, {1, 2, 3} [{1, 3} cannot be sub array as they are 
 *																				not consecutive]
 *
 *	ex: 
 *		i/p = {2, 3, -8, 7, -1, 2, 3}	=> o/p = 11 (7 + -1 + 2 + 3)
 *
 *		i/p = {5, 8, 3}					=> o/p = 16	(5 + 8 + 3)
 *
 *		i/p = {1, 2}					=> o/p = 3 (1 + 2)
 *
 *		i/p = {-6, -1, -8}				=> o/p = -1 (-1)
 *
 *	-> This is Kadane's algorithm: Consider each element as a last element of a sub array with contigeous members 
 *		and then apply below formula:
 * 
 * 													  |- max sub array sum for element at (i-1) + data(i)
 *	  max sub array sum for element at (i) = max of - |
 *													  |- data(i)
 *
 *		find max of such max sub array elements. 
 *
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class EfficientApproach {

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
		// start max sum with first element
		int maxSum = data[0];
		int subArraySum = data[0];

		int size = data.length;
		// find max sum for each element using the formula
		for(int index = 1; index < size; index++) {

			// find max sub array sum from (current value + previous max sum) OR only current value
			subArraySum = findMax((subArraySum+data[index]), data[index]);

			// find max out all above results
			maxSum = findMax(maxSum, subArraySum);
		}
		return maxSum;
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return max of num1 & num2
	 */
	private static int findMax(int num1, int num2) {
		return ((num1 > num2) ? (num1) : (num2));
	}

}
