/**
 * 
 */
package com.rotated.findLowest;

import java.util.Arrays;

/**
 * @author Harshal-Git
 * 
 *	Assumptions:
 *	An array of distinct numbers, sorted in increasing order. The array has been rotated (clockwise - right shifted) k number of times.
 *	This 'k' is unknown. Find given element from this array.
 *
 *	This approach might not give proper results with fully reverse sorted elements.
 *
 *	Approach 1: Binary search. 
 *
 *	1. Find a pivot point (index at which a(n) > a(n+1)) (using binary search) - a standard pivot finding method.
 *		Hence (pivot - 1) position will be the Max element in given array.		
 *
 *	2. Divide given array from this pivot point & perform binary search on both arrays based on:
 *		If search element is lesser than max element; search in left part of the array.
 *		Else search in the right part of the array.
 *
 * -> Time complexity: O(n) - linear search for lowest element in the given array  
 *
 *	-> Space complexity: O(1) - apart from 1 variable; no other data structures are used.
 *	  
 */
public class SearchInRotatedAp1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1 
		runCase(new int[] {5, 6, 1, 2, 3, 4}, 1);

		// case 2 
		runCase(new int[] {1, 2, 3, 4}, 1);

		// case 3 
		runCase(new int[] {1}, 2);

		// case 4 
		runCase(new int[] {1, 2}, 3);

		// case 5 S
		runCase(new int[] {5, 6, 7, 1, 2, 3, 4}, 1);

		// case 6 
		runCase(new int[] {1, 2, 3, 4, 5, 6, 7}, 8);

		// case 7 
		runCase(new int[] {2, 3, 4, 5, 6, 7, 8, 1}, 1);

		// case 8 
		runCase(new int[] {3, 4, 5, 1, 2}, 1);
	}

	/**
	 * method to run given case
	 * @param data - array data 
	 * @param searchElement - element to be searched
	 */
	private static void runCase(int[] data, int searchElement) {
		// find position of given element from given array
		int searchPos = findPosition(data, searchElement);
		if(searchPos < 0) {
			System.out.println("Element- "+searchElement+" could not be found in array "+Arrays.toString(data));
		} else {
			System.out.println("Element- "+searchElement+" found at position: "+(searchPos+1)+" in array "+Arrays.toString(data));
		}
	}

	/**
	 * method to find position of given element
	 * @param data - array data to search
	 * @param searchElement - element to be searched
	 * @return - returns position of given element OR -1 if not found
	 */
	private static int findPosition(int[] data, int searchElement) {
		// if data is null
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array.");
		}
		// length validation
		int length = data.length;
		// if array is single element & search result is present
		if(length == 1) {
			if(data[0] == searchElement) {
				return 0;
			} else {
				return -1;
			}
		}

		// if array is not rotated at all : perform binary search in full array
		if(data[0] < data[length-1]) {
			//System.out.println("BS executed.");
			return binarySearch(data, searchElement, 0, (length-1));
		} else {
			// find pivot in given array
			int pivot = findPivot(data, 0, (length-1));
			if(pivot < 0) {
				// no pivot found
				return -1;
			} else {
				// if search element is the pivot element
				if(data[pivot] == searchElement) {
					return pivot;
				}
				// if search element lesser than the pivot: perform left binary search
				if(searchElement < data[pivot-1]) {
					return binarySearch(data, searchElement, 0, (pivot-1));
				} else {
					return binarySearch(data, searchElement, (pivot+1), (length-1));
				}
			}
		}
	}

	/**
	 * method to get pivot element (OR lowest element index) from given array
	 * @param data - array data
	 * @param start - start position
	 * @param end - end position
	 * @return - pivot element 
	 */
	private static int findPivot(int[] data, int start, int end) {
		// if no element found; this might come as a condition
		if(start > end) {
			return -1;
		}
		// if single array
		if(start == end) {
			return start;
		}
		// find mid point
		int mid = start + ((end - start)/2);

		// check if 'mid' is pivot
		if(data[mid] < data[mid-1]) {
			return mid;
		}
		// check if 'mid+1' is pivot
		if(data[mid+1] < data[mid]) {
			return (mid+1);
		}
		// otherwise decide in which part of the array; 
		// we would like to search for pivot element
		if(data[mid] < data[end]) {
			// search in left part
			return findPivot(data, 0, (mid-1));
		} else {
			// search in right part
			return findPivot(data, (mid+1), end);
		}
	}

	/**
	 * method to perform binary search
	 * @param data - array data
	 * @param searchElement - element to be searched
	 * @param start - start position 
	 * @param end - end position
	 * @return - index of element to be searched OR -1 if element is not found
	 */
	private static int binarySearch(int[] data, int searchElement, int start, int end) {
		// if no element found; this might come as a condition
		if(start > end) {
			return -1;
		}
		// find mid position
		int mid = start + ((end - start)/2);
		// if mid element is required data
		if(data[mid] == searchElement) {
			return mid;
		} else if (searchElement < data[mid]) {
			// search in left half of the array
			return binarySearch(data, searchElement, 0, (mid-1));
		} else {
			// search in right half of the array
			return binarySearch(data, searchElement, (mid+1), end);
		}
	}
}
