/**
 * 
 */
package com.elementDeletion;

import java.util.Arrays;

/**
 * @author Harshal-Git
 * 	
 * -> Delete elements from a given array and re-arrange the array.
 *  
 *	ex: i/p : 3, 8, 12, 5, 6
 *		x = 12 (element to be deleted) 
 *
 *		=> o/p: 3, 8, 5, 6, _
 *
 *		i/p : 3, 8, 12, 5, 6
 *		x = 6 (element to be deleted)
 *			
 *		=> o/p: 3, 8, 12, 5, _
 *
 *	base line : array is fixed size & may OR many not be full. element to be deleted may be at any position. 
 *				size of the array is fixed and after deletion, capacity may change. Given element to be deleted 
 *				may OR may not be present in the array. 
 *				 
 * -> Time complexity:	O(n) : for search + O(n) : for shift = O(2n) ~ O(n)
 * 		-> Deletion from the beginning : 0(n)
 * 		-> Deletion at the end : 0(1)
 * -> Space complexity:	0(n) [includes the whole array]
 * -> Auxiliary space:  0(1) [additional storage elements]
 * 
 */
public class DeleteElementsFromArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int deleteElement;
		
		int [] data1 = {3, 8, 12, 5, 6};
		System.out.println("Array before delete: "+Arrays.toString(data1));
		deleteElement = 12; 
		System.out.println("Delete: "+deleteElement);
		deleteElement(data1, data1.length, 5, deleteElement);
		System.out.println("Array after delete: "+Arrays.toString(data1));
		
		int [] data2 = {3, 8, 12, 5, 6};
		System.out.println("\nArray before delete: "+Arrays.toString(data2));
		deleteElement = 6; 
		System.out.println("Delete: "+deleteElement);
		deleteElement(data2, data2.length, 5, deleteElement);
		System.out.println("Array after delete: "+Arrays.toString(data2));
		
		int [] data3 = {1, 3, 5, 7, 9};
		System.out.println("\nArray before delete: "+Arrays.toString(data3));
		deleteElement = 1; 
		System.out.println("Delete: "+deleteElement);
		deleteElement(data3, data3.length, 5, deleteElement);
		System.out.println("Array after delete: "+Arrays.toString(data3));
	}

	/**
	 * @param data - array data
	 * @param length - size of the array
	 * @param capacity - how many elements (non-default) are present
	 * @param deleteElement - element to be deleted
	 * @return - updated / original capacity of the array
	 */
	private static int deleteElement(int[] data, int size, int capacity, int deleteElement) {

		// if array is NULL or size is 0 : nothing to perform
		if(data == null || size == 0) {
			System.out.println("No operation can be performed.");
			return capacity;
		}
		// search for the element : linear search
		int position = -1;
		for(int index = 0; index < size; index++) {
			if(data[index] == deleteElement) {
				position = index;
				break;
			}
		}
		// once we have position, shift elements from that point onwards 
		for(int index = (position+1); index < size; index++) {
			data[index-1] = data[index];
		}
		// reset last element : if element is deleted
		if(position >= 0) {
			data[size-1] = 0;
			return (capacity-1);
		} else {
			// otherwise return original capacity
			return capacity;
		}
	}
}
