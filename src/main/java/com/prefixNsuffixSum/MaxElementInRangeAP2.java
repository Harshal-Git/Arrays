/**
 * 
 */
package com.prefixNsuffixSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> efficient approach : preparing an array of frequencies and finding the index of max frequency. The index of frequency 
 *							array will represent the values of range and array value will represent frequency. 
 *
 *
 *	-> base line : the array for storing frequencies needs to be more than the highest number of among ranges.
 *		
 *		Ex: In below example, max range is 18. So frequency array needs to be bigger than that. 
 *
 *		L = {1, 2, 5, 15}; R = {5, 8, 7, 18}	
 *		o/p => 5  
 *
 * -> Time complexity:	O(n) + O(n) = O(2*n) ~ O(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1) - constant size array
 */
public class MaxElementInRangeAP2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] leftRange1 = {1, 2, 3};
		int [] rightRange1 = {3, 5, 7};
		printMessage(leftRange1, rightRange1);

		int [] leftRange2 = {1, 2, 5, 15};
		int [] rightRange2 = {5, 8, 7, 18};
		printMessage(leftRange2, rightRange2);

	}

	/**
	 * @param leftRange
	 * @param rightRange
	 */
	private static void printMessage(int[] leftRange, int[] rightRange) {
		System.out.println("\nLeft range: "+Arrays.toString(leftRange));
		System.out.println("Right range: "+Arrays.toString(rightRange));
		System.out.println("Max occurring element: "+findMaxOccurringElement(leftRange, rightRange));
	}

	/**
	 * @param leftRange
	 * @param rightRange
	 * @return
	 */
	private static int findMaxOccurringElement(int[] leftRange, int[] rightRange) {

		int MAX_SIZE = 20;

		int size = leftRange.length;

		// fix sized array
		int [] prefixSumArr = new int[MAX_SIZE];

		// set flags at the position of ranges value 
		for(int index = 0; index < size; index++) {
			prefixSumArr[leftRange[index]]++;
			prefixSumArr[(rightRange[index]+1)]--;
		}
		//System.out.println("Prefix sum: "+Arrays.toString(prefixSumArr));

		// initialize max array
		int max = prefixSumArr[0];
		int result = 0;

		// prepare a prefix sum of the array with set flag  
		// values and find max element from the prefix sum
		for(int index = 1; index < MAX_SIZE; index++) {
			prefixSumArr[index] += prefixSumArr[index-1];
			if(max < prefixSumArr[index]) {
				max = prefixSumArr[index];
				result = index;
			}
		}
		return result;
	}
}
