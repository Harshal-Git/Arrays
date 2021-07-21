/**
 * 
 */
package com.maxDifference;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find max difference between 2 array elements (a[j] - a[i]) where j > i
 *		means difference = (right element - left element) should be max 
 *
 *	-> efficient approach : 
 *
 *		initialize 2 variables initially : minElement - as first element of the array
 *											maxDifference - difference between first 2 elements (j > i => a[j] - a[i])
 *		
 *		now iterate over the array for remaining elements and check whether difference of current element & the lowest 
 *		element found till now is higher OR default difference? whichever is higher; update the difference. 
 *
 *		meanwhile keep checking if we find any element lesser than current default value; change it also.	 
 *	
 *		ex: 
 *			i/p : 2, 3, 10, 6, 4, 8, 1 => o/p : 8 (10 - 2)
 * 
 *			i/p : 7, 9, 5, 6, 3, 2 => o/p : 2 (9 - 7)
 *
 *			i/p : 10, 20, 30 => o/p : 20 (30 - 10)
 *
 *			i/p : 30, 10, 8, 2 => o/p : -2 (8 - 10)	
 *
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 *   
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {2, 3, 10, 6, 4, 8, 1};
		System.out.println("Array: "+Arrays.toString(data1)+" => Max difference = "+findMaxDiff(data1));

		int [] data2 = {7, 9, 5, 6, 3, 2};
		System.out.println("Array: "+Arrays.toString(data2)+" => Max difference = "+findMaxDiff(data2));

		int [] data3 = {10, 20, 30};
		System.out.println("Array: "+Arrays.toString(data3)+" => Max difference = "+findMaxDiff(data3));

		int [] data4 = {30, 10, 8, 2};
		System.out.println("Array: "+Arrays.toString(data4)+" => Max difference = "+findMaxDiff(data4));
	}

	/**
	 * @param data - array data 
	 * @return
	 */
	private static int findMaxDiff(int[] data) {
		int size = data.length;
		/*
		 * there will be no negative calculation allowed if we set this 
		 * baseline as 0. Hence setting initial difference like this.
		 */
		int maxDifference = (data[1] - data[0]);
		int minVal = data[0];
		
		for(int index = 1; index < size; index++) {
			
			// find max value with existing max value & difference between current element & existing min value
			maxDifference = max(maxDifference, (data[index]-minVal));
			
			// keep updating existing min value also by comparing with current element
			minVal = min(minVal, data[index]);
		}
		return maxDifference;
	}

	/**
	 * @param num1
	 * @param num2
	 * @return lowest from num1 & num2
	 *  
	 */
	private static int min(int num1, int num2) {
		return ((num1 < num2)? num1: num2);
	}

	/**
	 * @param num1
	 * @param num2
	 * @return highest from num1 & num2
	 */
	private static int max(int num1, int num2) {
		return ((num1 > num2) ? num1: num2);
	}
}
