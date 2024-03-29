/**
 * 
 */
package com.prefixNsuffixSum.checkEquilibrium;

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
 *	-> efficient solution 2
 * 
 *		For each element check equilibrium point with below formula:
 *
 * 		left sum for data @ i = right sum for data @ i (total sum - data @ i)
 * 
 *  	Initially this left sum will be 0. If for current element @ i, the sum is not same, then-
 *  	
 *  	1. update the left sum by adding data 			
 *
 *	ex: 
 *		i/p : {3, 4, 8, -9, 20, 6}	=> o/p : Yes (left side sum of 20 = right side sum of 20)
 *
 *		i/p : {4, -2, 2}	=> o/p : Yes (left side sum of 4 = right side sum of 4)
 *
 *		i/p : {4, 2, 2}	=> o/p : No (No element is in equilibrium point for given array)
 *
 * -> Time complexity:	O(n) + O(n) = O(2*n) ~ O(n)
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  O(1)
 * 
 */
public class CheckEquilibriumAP3 {

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
		
		// compute total sum
		int totalSum = 0;
		for(int index = 0; index < size; index++) {
			totalSum += data[index];
		}
		
		// use left sum and keep subtracting elements
		int leftSum = 0;
		for(int index = 0; index < size; index++) {

			// if left sum is same as right sum (total sum - current element) 
			// return that equilibrium point
			if(leftSum == (totalSum - data[index])) {
				// equilibrium point
				//System.out.println("Equilibrium point: "+data[index]);
				return "Yes";
			}

			// otherwise update left sum and remove 
			// current element from total sum
			leftSum += data[index];
			totalSum -= data[index];
		}
		return "No";
	}

}
