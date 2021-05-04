/**
 * 
 */
package com.maxSumCircularSubArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find maximum sum of circular sub array 
 *	-> circular sub array can be found by connecting last element back to the first element and finding resulting sub arrays
 *	
 *	{10, 5, -5} => circular sub arrays = {10}, {5}, {-5}, {10, 5}, {5, -5}, {-5, 10}, {10, 5, -5}, {5, -5, 10}, {-5, 10, 5}
 *
 * 	ex: 
 * 		i/p : {5, -2, 3, 4} => o/p : 12 (3+4+5)
 * 
 * 		i/p : {2, 3, -4} => o/p : 5 (2+3)
 * 
 * 		i/p : {8, -4, 3, -5, 4} => o/p : 12 (8+4)
 * 
 * 		i/p : {-3, 4, 6, -2} => o/p : 10 (4+6)
 * 
 * 		i/p : {-8, 7, 6} => o/p : 13 (7+6)
 * 
 * 		i/p : {3, -4, 5, 6, -8, 7} => o/p : 17 (7+3-4+5+6)
 *						 
 *	-> efficient approach : take maximum of the following values 
 *
 *		1. maximum sum of the normal array (following Kadaen's algo)
 *		2. maximum sum of a circular array  (sum of normal array - lowest sum of sub array)
 *
 * -> Time complexity:	0(n) + 0(n) + 0(n) = 0(3n) ~ 0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {5, -2, 3, 4};
		System.out.println("Array: "+Arrays.toString(data1)+" -> Max circular sub array sum = "+findMaxCircularSum(data1));

		int [] data2 = {2, 3, -4};
		System.out.println("\nArray: "+Arrays.toString(data2)+" -> Max circular sub array sum = "+findMaxCircularSum(data2));

		int [] data3 = {8, -4, 3, -5, 4};
		System.out.println("\nArray: "+Arrays.toString(data3)+" -> Max circular sub array sum = "+findMaxCircularSum(data3));

		int [] data4 = {-3, 4, 6, -2};
		System.out.println("\nArray: "+Arrays.toString(data4)+" -> Max circular sub array sum = "+findMaxCircularSum(data4));

		int [] data5 = {-8, 7, 6};
		System.out.println("\nArray: "+Arrays.toString(data5)+" -> Max circular sub array sum = "+findMaxCircularSum(data5));

		int [] data6 = {3, -4, 5, 6, -8, 7};
		System.out.println("\nArray: "+Arrays.toString(data6)+" -> Max circular sub array sum = "+findMaxCircularSum(data6));
	}

	/**
	 * @param data - array data
	 * @return
	 */
	private static int findMaxCircularSum(int[] data) {
		int size = data.length;

		// find normal max sum from sub array Kadaen's algo
		int maxNormalSubarray = findMaxSumFromNormalSubarray(data);

		// this means that all elements are negative; return the normal sub array sum
		if(maxNormalSubarray < 0) {
			return maxNormalSubarray;
		}

		/*
		 * formula finding max sum of circular sub array:
		 * 
		 * 		(sum of normal array - lowest sum of sub array)
		 * 
		 * this is divided in 2 parts
		 * 
		 * 1. sum of normal array
		 * 2. lowest sub array sum  
		 */
		int sumArray = 0;
		for(int index = 0; index < size; index++) {
			sumArray+= data[index];			// sum of normal array
			data[index] = (-data[index]);	// array inversion
		}
		/*
		 * (lowest sum of sub array) = (highest sum of inverted sub array)
		 * 
		 * to use the same Kadaen's function without any change; inverted array is used.
		 */
		int maxCircularSum = sumArray + findMaxSumFromNormalSubarray(data);

		// return max of both calculations 
		return findMax(maxNormalSubarray, maxCircularSum);
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findMaxSumFromNormalSubarray(int[] data) {
		int maxFinalSum = data[0];
		int maxSubarraySum = data[0];
		int size = data.length;

		// iterate over all elements and find max sub array sum
		for(int index = 1; index < size; index++) {

			// find max out of previous sum element & current array element
			maxSubarraySum = findMax((maxSubarraySum + data[index]), data[index]);

			// find resulting max out of all sub array's sum
			maxFinalSum = findMax(maxSubarraySum, maxFinalSum);
		}
		return maxFinalSum;
	}

	/**
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int findMax(int num1, int num2) {
		return ((num1 > num2) ? (num1) : (num2));
	}

}