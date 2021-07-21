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
 *
 *	-> naive approach : find left & right elements sum for each element of the array and when they both become
 *						same for any element; return that equilibrium point. 
 *
 *	ex: 
 *		i/p : {3, 4, 8, -9, 20, 6}	=> o/p : Yes (left side sum of 20 = right side sum of 20)
 *
 *		i/p : {4, -2, 2}	=> o/p : Yes (left side sum of 4 = right side sum of 4)
 *
 *		i/p : {4, 2, 2}	=> o/p : No (No element is in equilibrium point for given array)
 *
 * -> Time complexity:	O(n * (n/2 + n/2)) = O(n*n) ~ O(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class CheckEquilibriumAP1 {

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

		int leftSum = 0, rightSum = 0;
		int size = data.length;

		// iterate over all elements and find left & right sum
		for(int index = 0; index < size; index++) {

			// find left sum
			leftSum = 0;
			for(int leftIndex = 0; leftIndex < index; leftIndex++) {
				leftSum += data[leftIndex];
			}

			// find right sum
			rightSum = 0;
			for(int rightIndex = (index+1); rightIndex < size; rightIndex++) {
				rightSum += data[rightIndex];
			}
			
			// if both side sum is same : that's equilibrium point
			if(leftSum == rightSum) {
				// equilibrium point
				//System.out.println("Equilibrium point: "+data[index]);
				return "Yes";
			}
		}
		// no equilibrium point found
		return "No";
	}

}
