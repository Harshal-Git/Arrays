/**
 * 
 */
package com.prefixNsuffixSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> for a given array; process the queries of specific nature.
 *
 *	ex:
 * 
 *	data = {2, 8, 3, 9, 6, 5, 4};
 *	
 *	Queries: 
 *			getSum(0, 2)	=> 13
 *
 *			getSum(1, 3)	=> 20
 *
 *			getSum(2, 6)	=> 27
 *
 *	-> naive approach : iterate over the given elements and find sum : including the points
 *
 * -> Time complexity:	O(right - left) ~ O(n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class ProcessQueriesNaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data = {2, 8, 3, 9, 6, 5, 4};
		System.out.println("Array: "+Arrays.toString(data));
		System.out.println("Queries: ");
		System.out.println("getSum(0, 2) = "+getSum(0, 2, data));
		System.out.println("getSum(1, 3) = "+getSum(1, 3, data));
		System.out.println("getSum(2, 6) = "+getSum(2, 6, data));
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @param data
	 * @return
	 */
	private static int getSum(int start, int end, int[] data) {
		int sum = 0;
		// iterate over given points : including those points
		for(int index = start; index <= end; index++) {
			sum += data[index];
		}
		return sum;
	}
}
