/**
 * 
 */
package com.findLargestElement;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find largest element from the given array (find index of the largest element)
 *
 *	-> standard approach 
 *
 *	-> base line : if duplicate largest elements are found, it will return the first ever encountered.
 *
 * -> Time complexity: 0(n) - will iterate through all elements even if largest is found
 * -> Space complexity:	0(n) [includes the whole array]
 * -> Auxiliary space:  0(1) [additional storage elements]
 */
public class FindLargestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int largestIndex;
		
		int [] data1 = {3, 8, 12, 5, 6};
		largestIndex = findLargestElementIndex(data1);
		printMessage(data1, largestIndex);

		int [] data2 = {9, 7, 5, 3, 1};
		largestIndex = findLargestElementIndex(data2);
		printMessage(data2, largestIndex);

		int [] data3 = {2, 4, 6, 8, 10};
		largestIndex = findLargestElementIndex(data3);
		printMessage(data3, largestIndex);
		
		int [] data4 = {2};
		largestIndex = findLargestElementIndex(data4);
		printMessage(data4, largestIndex);
		
		int [] data5 = {1, 2};
		largestIndex = findLargestElementIndex(data5);
		printMessage(data5, largestIndex);
		
		int [] data6 = {9, 2};
		largestIndex = findLargestElementIndex(data6);
		printMessage(data6, largestIndex);
		
		int [] data7 = {5, 8, 12, 20, 20};
		largestIndex = findLargestElementIndex(data7);
		printMessage(data7, largestIndex);
		
		int [] data8 = {5, 8, 12, 12, 20};
		largestIndex = findLargestElementIndex(data8);
		printMessage(data8, largestIndex);
	}

	/**
	 * @param data
	 * @param largestIndex
	 */
	private static void printMessage(int[] data, int largestIndex) {
		System.out.println("\nArray: "+Arrays.toString(data)+" Largest element: "+
				data[largestIndex]+" at position: "+(largestIndex+1));
	}

	/**
	 * @param data - array data
	 * @return - largest index of the element from given array
	 */
	public static int findLargestElementIndex(int[] data) {
		int largestIndex = 0;	// default first element largest
		for(int index = 0; index < data.length; index++) {
			if(data[largestIndex] < data[index]) {
				largestIndex = index;
			}
		}
		return largestIndex;
	}
}
