/**
 * 
 */
package com.removeDuplicates;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> remove duplicate elements from given sorted array
 *
 *	-> standard approach: using temp array to insert only distinct elements
 *
 *	ex: 
 *		i/p : 10, 20, 20, 30, 30, 30 (size=7) ==> o/p : 10, 20, 30, _, _, _, _ 	(size=3)
 *
 *		i/p : 10, 10, 10 (size=3) ==> o/p : 10, _, _	(size=1)
 *
 *	-> base line: array is full initially and sorted. updated capacity is expected in return to understand how many elements 
 *					are actually removed.
 * 
 * -> Time complexity:	0(n)+0(n) = 0(2n) ~ 0(n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 * 
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int updatedCapacity;
		
		int [] data1 = {10, 20, 20, 30, 30, 30};
		System.out.println("Array before: "+Arrays.toString(data1));
		updatedCapacity = removeDuplicates(data1);
		System.out.println("Array after: "+Arrays.toString(data1)+" -> updated capacity: "+updatedCapacity);
		
		int [] data2 = {10, 10, 10};
		System.out.println("\nArray before: "+Arrays.toString(data2));
		updatedCapacity = removeDuplicates(data2);
		System.out.println("Array after: "+Arrays.toString(data2)+" -> updated capacity: "+updatedCapacity);
	}

	/**
	 * @param data - array for which duplicates are to be removed
	 * @return - updated capacity
	 */
	private static int removeDuplicates(int[] data) {
		int lastIndex = 0;
		int lastElement = -1;
		// temp array creation
		int [] tempData = new int[data.length];
		// copy all elements uniquely to temp array
		for(int index= 0; index < data.length; index++) {
			if(lastElement != data[index]) {
				tempData[lastIndex] = data[index];
				lastIndex++;
				lastElement = tempData[lastIndex-1];
			}
		}
		// copy temp array into original array
		for(int index = 0; index < tempData.length; index++) {
			data[index] = tempData[index];
		}
		return lastIndex;
	}

}
