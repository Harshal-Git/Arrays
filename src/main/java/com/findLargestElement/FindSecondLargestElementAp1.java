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

		int [] data = null;

		data = new int[] {3, 8, 12, 5, 6};
		printData(data, findSecondLargestElement(data));

		data = new int[] {6, 2, 9};
		printData(data, findSecondLargestElement(data));

		data = new int[] {2, 4, 6, 8, 10};
		printData(data, findSecondLargestElement(data));

		data = new int[] {2};
		printData(data, findSecondLargestElement(data));

		data = new int[] {1, 2};
		printData(data, findSecondLargestElement(data));

		data = new int[] {2, 9};
		printData(data, findSecondLargestElement(data));

		data = new int[] {10, 10, 10};
		printData(data, findSecondLargestElement(data));

		data = new int[] {5, 8, 12, 20, 20};
		printData(data, findSecondLargestElement(data));

		data = new int[] {5, 20, 12, 20, 8};
		printData(data, findSecondLargestElement(data));

		data = new int[] {10, 10, 10, 8};
		printData(data, findSecondLargestElement(data));
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
