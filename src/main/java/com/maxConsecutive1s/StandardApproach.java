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

		int [] data1 = {0, 1, 1, 0, 1, 1, 1, 0};
		System.out.println("Array: "+Arrays.toString(data1)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data1));

		int [] data2 = {1, 1, 1, 1};
		System.out.println("Array: "+Arrays.toString(data2)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data2));

		int [] data3 = {0, 0, 0, 0};
		System.out.println("Array: "+Arrays.toString(data3)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data3));

		int [] data4 = {1, 0, 1, 1, 1, 1, 0, 1, 1};
		System.out.println("Array: "+Arrays.toString(data4)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data4));
		
		int [] data5 = {1, 0, 0, 0};
		System.out.println("Array: "+Arrays.toString(data5)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data5));
		
		int [] data6 = {0, 0, 0, 1};
		System.out.println("Array: "+Arrays.toString(data6)+" -> Maximum consecutive 1s is/are: "+findMaxConsecutive1s(data6));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findMaxConsecutive1s(int[] data) {
		int maxConsecutiveCount = 0;
		int size = data.length;
		int consecutiveCount = 0;
		// iterate through all elements
		for(int index = 0; index < size; index++) {
			// if 1 encountered
			if(data[index] == 1) {
				consecutiveCount++;
			} else {
				consecutiveCount = 0;
			}
			// at each step; find maximum consecutive length found
			maxConsecutiveCount = (maxConsecutiveCount > consecutiveCount)? maxConsecutiveCount : consecutiveCount;
		}
		// return heightst consecutive count
		return maxConsecutiveCount;
	}
}
