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
 *	-> efficient approach: using same array and rearranging the elements such that all distinct elements 
 *							will be shifted to left side.
 *			
 *						but this approach will not completely make the existing array filled with unique elements. some elements 
 *						will still be present as duplicated elements; but those can be ignored with updated capacity. 
 *
 *	ex: 
 *		i/p : 10, 20, 20, 30, 30, 30 (size=7) ==> o/p : 10, 20, 30, _, _, _, _ 	(size=3)
 *
 *		i/p : 10, 10, 10 (size=3) ==> o/p : 10, _, _	(size=1)
 *
 *	-> base line: array is full initially and sorted. updated capacity is expected in return to understand how 
 *					many elements are actually removed.
 * 
 * -> Time complexity:	0(n) - single pass of the whole array 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int updatedCapacity;
		
		int [] data1 = {10, 20, 20, 30, 30, 30, 40, 40};
		System.out.println("Array before: "+Arrays.toString(data1));
		updatedCapacity = removeDuplicates(data1);
		System.out.println("Array after: "+Arrays.toString(data1)+" -> updated capacity: "+updatedCapacity);
		
		int [] data2 = {10, 10, 10};
		System.out.println("Array before: "+Arrays.toString(data2));
		updatedCapacity = removeDuplicates(data2);
		System.out.println("Array after: "+Arrays.toString(data2)+" -> updated capacity: "+updatedCapacity);
	}

	/**
	 * @param data - array for which duplicates are to be removed
	 * @return - updated capacity
	 */
	private static int removeDuplicates(int[] data) {
		int lastIndex = 1; // consider first element is already processed
		for(int index= 1; index < data.length; index++) {
			if(data[lastIndex-1] != data[index]) {
				data[lastIndex] = data[index];
				lastIndex++;
			}
		}
		return lastIndex;
	}

}
