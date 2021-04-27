/**
 * 
 */
package com.checkSort;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> for a given array, check whether the array is increasingly sorted OR not. Return Yes / No accordingly.
 *
 *	ex: 
 *		i/p : 8, 12, 15	==> o/p : Yes
 *		i/p : 8, 10, 10, 12 ==> o/p : Yes
 *		i/p : 100 ==> o/p : Yes
 *		i/p : 100, 20 200 ==> o/p : No
 *
 *	-> Time complexity: O(n) - single pass of the whole array max up to all elements
 *  -> Space complexity: 0(n)
 *  -> Auxiliary space: 0(1)
 */
public class Approach1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {8, 12, 15};
		System.out.println("If array: "+Arrays.toString(data1)+" is sorted? "+isSorted(data1));

		int [] data2 = {8, 10, 10, 12};
		System.out.println("If array: "+Arrays.toString(data2)+" is sorted? "+isSorted(data2));

		int [] data3 = {100};
		System.out.println("If array: "+Arrays.toString(data3)+" is sorted? "+isSorted(data3));

		int [] data4 = {100, 20, 200};
		System.out.println("If array: "+Arrays.toString(data4)+" is sorted? "+isSorted(data4));

		int [] data5 = {100, 100, 100};
		System.out.println("If array: "+Arrays.toString(data5)+" is sorted? "+isSorted(data5));
	}

	/**
	 * @param data - array data
	 * @return boolean - whether array is increasingly sorted OR not
	 */
	private static boolean isSorted(int[] data) {
		// be default, array is sorted
		boolean isSorted= true;
		int length = data.length;
		for(int index = 0; index < (length-1); index++) {
			// if array still sorted & upcoming elements are also proper
			if(isSorted && (data[index] > data[index+1])) {		// here boolean condition is applied to avoid writing 'break' statement
				isSorted = false;
			}
		}
		return isSorted;
	}
}
