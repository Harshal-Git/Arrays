/**
 * 
 */
package com.findLargestElement;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find second largest element from the given array (find index of the second largest element)
 *
 *	-> standard approach : Find largest index first and then except that index; find largest out of remaining elements.
 *
 *	-> base line : there may be chances of second largest element not present (all elements are same). with current 
 *					logic, such cases are handled. 
 *
 *	-> Time complexity: 0(n) + 0(n) = 0(2n) ~ 0(n) - will iterate through all elements twice in sequence
 *  -> Space complexity:	0(n) [includes the whole array]
 *  -> Auxiliary space:  0(1) [additional storage elements]
 */
public class FindSecondLargestElementAp1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int secondLargest;

		int [] data1 = {3, 8, 12, 5, 6};
		secondLargest = findSecondLargestElement(data1);
		printData(data1, secondLargest);

		int [] data2 = {6, 2, 9};
		secondLargest = findSecondLargestElement(data2);
		printData(data2, secondLargest);

		int [] data3 = {2, 4, 6, 8, 10};
		secondLargest = findSecondLargestElement(data3);
		printData(data3, secondLargest);

		int [] data4 = {2};
		secondLargest = findSecondLargestElement(data4);
		printData(data4, secondLargest);

		int [] data5 = {1, 2};
		secondLargest = findSecondLargestElement(data5);
		printData(data5, secondLargest);

		int [] data6 = {2, 9};
		secondLargest = findSecondLargestElement(data6);
		printData(data6, secondLargest);

		int [] data7 = {10, 10, 10};
		secondLargest = findSecondLargestElement(data7);
		printData(data7, secondLargest);

		int [] data8 = {5, 8, 12, 20, 20};
		secondLargest = findSecondLargestElement(data8);
		printData(data8, secondLargest);

		int [] data9 = {5, 20, 12, 20, 8};
		secondLargest = findSecondLargestElement(data9);
		printData(data9, secondLargest);
		
		int [] data10 = {10, 10, 10, 8};
		secondLargest = findSecondLargestElement(data10);
		printData(data10, secondLargest);

	}

	/**
	 * @param data
	 * @param secondLargestIndex
	 */
	private static void printData(int[] data, int secondLargestIndex) {
		if(secondLargestIndex >= 0) {
			System.out.println("\nArray: "+Arrays.toString(data)+" Second largest element: "+
					data[secondLargestIndex]+" at position: "+(secondLargestIndex+1));
		} else {
			System.out.println("\nNo second largest element found from "+Arrays.toString(data));
		}
	}

	/**
	 * @param data - array data
	 * @return - second largest index of the element from given array
	 */
	private static int findSecondLargestElement(int[] data) {
		// find largest element
		int largestIndex = FindLargestElement.findLargestElementIndex(data);	
		// find second largest index : skip actual largest index  
		int secondLargest = 0;
		boolean elementFound = false;
		for(int index = 0; index < data.length; index++) {
			if(data[index] != data[largestIndex]) {
				if(data[secondLargest] < data[index]) {
					secondLargest = index;
				}
				elementFound = true;
			}
		}
		if(elementFound) {
			return secondLargest;
		} else {
			return -1;
		}
	}
}
