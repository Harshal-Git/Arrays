/**
 * 
 */
package com.maxConsecutive1s;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find max numbers of consecutive 1s from a given binary array
 *
 *	-> standard approach : keep counting 1s. The moment 0 is encountered, consider count value till now, and find max out of 
 *							current count & previous count value.
 *
 *	-> ex:
 *			i/p : {0, 1, 1, 0, 1, 0}	==> o/p: 2 (position 2 & 3)
 *
 *			i/p : {1, 1, 1, 1}	==> o/p: 4 
 *
 *			i/p : {0, 0, 0}	==> o/p: 0
 *
 *			i/p : {1, 0, 1, 1, 1, 1, 0, 1, 1} ==> o/p: 4 (position 2 to 5)
 *
 * -> Time complexity: 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 1, 1, 0, 1, 0};
		System.out.println("Array: "+Arrays.toString(data1)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data1));
		
		int [] data2 = {1, 1, 1, 1};
		System.out.println("Array: "+Arrays.toString(data2)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data2));
		
		int [] data3 = {0, 0, 0, 0};
		System.out.println("Array: "+Arrays.toString(data3)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data3));
		
		int [] data4 = {1, 0, 1, 1, 1, 1, 0, 1, 1};
		System.out.println("Array: "+Arrays.toString(data4)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data4));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findMaxConsecutive1s(int[] data) {
		int maxCount = 0;
		int size = data.length;
		int tempCount = 0;
		// iterate through all elements
		for(int index = 0; index < size; index++) {
			if(data[index] == 0) {
				// check and assign count values accordingly
				if(maxCount < tempCount) {
					maxCount = tempCount;
				}
				// reset temp count when 0 is encountered
				tempCount = 0;
			} else {
				// increment temp count
				tempCount++;
			}
		}
		return getMax(maxCount, tempCount);
	}

	/**
	 * @param maxCount
	 * @param tempCount
	 * @return
	 */
	private static int getMax(int maxCount, int tempCount) {
		return ((maxCount < tempCount) ? (tempCount) : (maxCount));
	}

}
