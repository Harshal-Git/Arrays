/**
 * 
 */
package com.maxSumCircularSubArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find maximum sum of circular sub array 
 *	-> circular sub array can be found by connecting last element back to the first element and finding resulting sub arrays. This 
 *		iteration will be valid till we reach back to the same element.
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
 *	-> naive approach : for every element, find all sum of all circular elements and keep record of the max sum
 *
 * -> Time complexity:	0(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class NaiveApproach {

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
		int maxSum = 0;
		int currentSubArraySum = 0;
		int size = data.length;	
		int circularIndex = 0;
		
		// iterate over all elements and find sum of current element sub arrays
		for(int index = 0; index < size; index++) {
			
			// reset current sub array sum
			currentSubArraySum = 0;
			
			// find all sub arrays sum
			for(int count = 0; count < size; count++) {
				// calculation of circular sub array index
				circularIndex = ((index+count)%size);
				currentSubArraySum += data[circularIndex];
				
				// get max sum from all sub array calculation
				maxSum = ((maxSum < currentSubArraySum) ? (currentSubArraySum) : (maxSum));
			}
		}
		return maxSum;
	}

}