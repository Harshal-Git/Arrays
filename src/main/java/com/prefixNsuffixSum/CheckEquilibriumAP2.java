/**
 * 
 */
package com.prefixNsuffixSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> check for given array whether it has any equilibrium point?
 *
 *	Equilibrium point: An element for which sum of all elements on left side & sum of all elements on right side is same.
 *						If there are no elements on either side then sum can be considered as 0. Here that particular
 *						element will not be considered in sum. 
 *
 *	-> efficient solution : find prefix & suffix sum and for all array elements. Iterate both arrays & the point where they both 
 *							are found same; that's equilibrium point of the given array.
 *
 *	ex: 
 *		i/p : {3, 4, 8, -9, 20, 6}	=> o/p : Yes (left side sum of 20 = right side sum of 20)
 *
 *		i/p : {4, -2, 2}	=> o/p : Yes (left side sum of 4 = right side sum of 4)
 *
 *		i/p : {4, 2, 2}	=> o/p : No (No element is in equilibrium point for given array)
 *
 * -> Time complexity:	O(n) + O(n) + O(n) = O(3*n) ~ O(n)
 * -> Space complexity:	0(n) + 0(n) = 0(2*n) ~ 0(n)
 * -> Auxiliary space:  0(n) + 0(n) = 0(2*n) ~ 0(n)
 * 
 */
public class CheckEquilibriumAP2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {3, 4, 8, -9, 20, 6};
		System.out.println("Array: "+Arrays.toString(data1)+" has an equilibrium point? "
				+hasEquilibriumPoint(data1));

		int [] data2 = {4, -2, 2};
		System.out.println("\nArray: "+Arrays.toString(data2)+" has an equilibrium point? "
				+hasEquilibriumPoint(data2));
		
		int [] data3 = {4, 2, 2};
		System.out.println("\nArray: "+Arrays.toString(data3)+" has an equilibrium point? "
				+hasEquilibriumPoint(data3));
		
		int [] data4 = {2, -2, 4};
		System.out.println("\nArray: "+Arrays.toString(data4)+" has an equilibrium point? "
				+hasEquilibriumPoint(data4));
	}

	/**
	 * @param data 
	 * @return
	 */
	private static String hasEquilibriumPoint(int[] data) {

		int size = data.length;
		
		int [] prefixSum = new int[size];
		int [] suffixSum = new int[size];
		
		// set initial values for both arrays
		prefixSum[0] = data[0];
		suffixSum[size-1] = data[size-1];
		
		// find prefix sum
		for(int index = 1; index < size; index++) {
			prefixSum[index] = (prefixSum[(index-1)]+data[index]);
		}
		
		// find suffix sum
		for(int index = (size-2); index >= 0; index--) {
			suffixSum[index] = (suffixSum[(index+1)]+data[index]);
		}
		
		// find point where prefix & suffix sum are same
		for(int index = 0; index < size; index++) {
			if(prefixSum[index] == suffixSum[index]) {
				// equilibrium point
				//System.out.println("Equilibrium point: "+data[index]);
				return "Yes";
			}
		}
		// no equilibrium point found
		return "No";
	}

}
