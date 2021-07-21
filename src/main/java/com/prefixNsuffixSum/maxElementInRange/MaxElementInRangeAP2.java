/**
 * 
 */
package com.prefixNsuffixSum.maxElementInRange;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> efficient approach : use an fixed size array to store the frequency of elements obtained from given range. 
 *
 * 		Trick here is the way start number & end number is stored in the frequency array. 
 * 
 * 		It is done so that when prefix sum of the array is done; it will immediately reflect the exact frequency of the elements.  
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

		int [] leftRange = null;
		int [] rightRange = null;

		leftRange = new int[] {1, 2, 3};
		rightRange = new int[] {3, 5, 7};
		printMessage(leftRange, rightRange);

		leftRange = new int[] {1, 2, 5, 15};
		rightRange = new int[] {5, 8, 7, 18};
		printMessage(leftRange, rightRange);

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
		int [] freqArr = new int[MAX_SIZE];

		// set flags at the position of ranges value 
		for(int index = 0; index < size; index++) {
			freqArr[leftRange[index]]++;			// TRICK PART (freqArr[begin_value]++)
			freqArr[(rightRange[index]+1)]--;		// TRICK PART (freqArr[end_value+1]--)
			//System.out.println("Freq arr: "+Arrays.toString(freqArr));
		}

		// initialize max array
		int max = freqArr[0];
		int result = 0;

		// prepare a prefix sum of the frequency array with set flag  
		// values and find max element from the prefix sum
		for(int index = 1; index < MAX_SIZE; index++) {
			freqArr[index] += freqArr[index-1];
			//System.out.println("Prefix freq arr: "+Arrays.toString(freqArr));
			if(max < freqArr[index]) {
				max = freqArr[index];
				result = index;
			}
		}
		return result;
	}
}
