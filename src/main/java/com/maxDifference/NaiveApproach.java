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
 *	-> standard approach : take each element and check it with all right elements to calculate (a[j] - a[i]) till the 
 *		max difference is found.
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
		if(data == null || size < 2) {
			throw new IllegalArgumentException("Invalid array input.");
		}

		/*
		 * there will be no negative calculation allowed if we set this 
		 * baseline as 0. Hence setting initial difference like this.
		 */
		int difference = (data[1] - data[0]);

		int tempDiff;
		for(int index = 0; index < size; index++) {
			for(int count = (index+1); count < size; count++) {
				tempDiff = (data[count] - data[index]);
				if(difference < tempDiff) {
					difference = tempDiff;
				}
			}
		}
		return difference;
	}

}
