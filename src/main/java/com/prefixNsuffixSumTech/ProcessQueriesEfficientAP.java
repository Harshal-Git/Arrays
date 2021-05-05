/**
 * 
 */
package com.prefixNsuffixSumTech;

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
 *	-> efficient approach : pre-calculate sum of all elements & then return queries on constant time
 *
 * -> Time complexity:	0(n) [for prefix calculation], 0(1) [for query execution]
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class ProcessQueriesEfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data = {2, 8, 3, 9, 6, 5, 4};
		System.out.println("Array: "+Arrays.toString(data));

		// pre-calculate sum
		int [] sumData = getPrefixSum(data);
		//System.out.println("Prefix Array: "+Arrays.toString(sumData));

		System.out.println("Queries: ");
		System.out.println("getSum(0, 2) = "+getSum(0, 2, sumData));
		System.out.println("getSum(1, 3) = "+getSum(1, 3, sumData));
		System.out.println("getSum(2, 6) = "+getSum(2, 6, sumData));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int[] getPrefixSum(int[] data) {
		int size = data.length;
		int [] prefixSumData = new int[size];
		prefixSumData[0] = data[0];

		// iterate over all elements and find prefix sum
		for(int index = 1; index < size; index++) {
			prefixSumData[index] = (prefixSumData[(index-1)] + data[index]);
		}
		return prefixSumData;
	}

	/**
	 * @param start
	 * @param end
	 * @param data
	 * @return
	 */
	private static int getSum(int start, int end, int[] data) {
		if(start == 0) {
			return data[end];
		} else {
			return (data[end] - data[(start-1)]);
		}
	}
}
