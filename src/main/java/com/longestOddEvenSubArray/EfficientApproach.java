/**
 * 
 */
package com.longestOddEvenSubArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find longest sub array with odd/even alternate data
 *
 *	-> efficient approach: find the max length EVEN/ODD sub array in a single pass 
 *
 * 	-> ex:
 * 			i/p: {10, 12, 14, 7, 8}	=> o/p : 3 (from 3 to 5)
 * 
 * 			i/p: {7, 10, 13, 14}	=> o/p : 4 
 * 
 * 			i/p: {10, 12, 8}	=> o/p : 1 
 *  
 * -> Time complexity:	O(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 12, 14, 7, 8};
		System.out.println("Array: "+Arrays.toString(data1)+" --> Longest even/odd sub array: "+findLongestEvenOddSubArray(data1));

		int [] data2 = {7, 10, 13, 14};
		System.out.println("\nArray: "+Arrays.toString(data2)+" --> Longest even/odd sub array: "+findLongestEvenOddSubArray(data2));

		int [] data3 = {10, 12, 8};
		System.out.println("\nArray: "+Arrays.toString(data3)+" --> Longest even/odd sub array: "+findLongestEvenOddSubArray(data3));

		int [] data4 = {5, 10, 20, 6, 3, 8};
		System.out.println("\nArray: "+Arrays.toString(data4)+" --> Longest even/odd sub array: "+findLongestEvenOddSubArray(data4));
	}

	/**
	 * @param data - array data
	 * @return-  longest sub array with even / odd sub array
	 */
	private static int findLongestEvenOddSubArray(int[] data) {
		int maxLength = 1;
		int size = data.length;
		// first element will be either EVEN / ODD
		int subArrayLength = 1;

		// iterate over all elements
		for(int index = 1; index < size; index++) {
			// check if current & previous element are valid : keep counting 
			if(areElementsValid(data, index)) {
				subArrayLength++;
			} else {
				// otherwise reset the count
				subArrayLength = 1;
			}
			// find max length out of previous & current sub array
			maxLength = ((maxLength > subArrayLength) ? (maxLength) : (subArrayLength));
		}
		return maxLength;
	}

	/**
	 * @param data
	 * @param count
	 * @return
	 */
	private static boolean areElementsValid(int[] data, int count) {
		int currentElement = data[count];
		int previousElement = data[count-1];
		// check whether current is ODD & previous is EVEN OR current is EVEN & previous is ODD		
		if(((currentElement % 2 == 0) && (previousElement % 2 != 0)) || 
				((currentElement % 2 != 0) && (previousElement % 2 == 0))) {
			return true;
		}
		return false;
	}

}
