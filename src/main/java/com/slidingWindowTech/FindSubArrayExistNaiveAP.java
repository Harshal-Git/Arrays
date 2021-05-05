/**
 * 
 */
package com.slidingWindowTech;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> an array with all natural integer and a sum are given. Find whether any sun array exist with given sum? (Yes/No)
 *
 * 	-> using sliding window technique
 * 
 * 	ex:
 * 		i/p: {1, 4, 20, 3, 10, 5} & sum = 33 	=> o/p: Yes
 * 
 * 		i/p: {1, 4, 0, 0, 3, 10, 5} & sum = 7 	=> o/p: Yes
 * 
 * 		i/p: {2, 4} & sum = 3 					=> o/p: No
 * 
 * 		i/p = {2, 3, -8, 7, -1, 2, 3} & sum = 11 => o/p: Yes 
 *
 *		i/p = {5, 8, 3}	& sum = 16				=> o/p : Yes
 *
 *		i/p = {-6, -1, -8}	=> o/p = -3			=> o/p : No			
 * 
 * -> Time complexity:	O(n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class FindSubArrayExistNaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int sum;

		int [] data1 = {1, 4, 20, 3, 10, 5};
		sum = 32;
		printMessage(data1, sum);

		int [] data2 = {1, 4, 20, 3, 10, 5};
		sum = 33;
		printMessage(data2, sum);

		int [] data3 = {1, 4, 0, 0, 3, 10, 5};
		sum = 7;
		printMessage(data3, sum);

		int [] data4 = {2, 4};
		sum = 3;
		printMessage(data4, sum);

		int [] data5 = {2, 3, -8, 7, -1, 2, 3};
		sum = 11;
		printMessage(data5, sum);
		
		int [] data6 = {5, 8, 3};
		sum = 16;
		printMessage(data6, sum);
		
		int [] data7 = {-6, -1, -8};
		sum = -3;
		printMessage(data7, sum);
		sum = -1;
		printMessage(data7, sum);
	}

	/**
	 * @param data1
	 * @param sum
	 */
	private static void printMessage(int[] data, int sum) {
		System.out.println("\nIs a sub array in "+Arrays.toString(data)+" present with sum = "+sum
				+" ? : "+findSumPresent(data, sum));
	}

	/**
	 * @param data1
	 * @param sum
	 * @return
	 */
	private static String findSumPresent(int[] data, int sum) {

		// initializations
		int size = data.length;
		int windowSum = 0;

		// iterate over all elements and check whether we can find sum as asked?
		for(int index = 0; index < size; index++) {
			
			// reset window sum for all new elements
			windowSum = 0;
			
			// iterate over remaining elements to find respective sum
			for(int count = index; count < size; count++) {
				windowSum += data[count];
				
				if(windowSum == sum) {
					return "Yes";
				}
			}
		}
		// if we don't find required sum
		return "No";
	}

}
