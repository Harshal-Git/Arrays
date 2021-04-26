/**
 * 
 */
package com.elementInsertion;

import java.util.Arrays;

/**
 * @author Harshal-Git
 * 	
 * -> Insert elements in a given array
 * 		base line : array is fixed size but not full. So there will be right most elements which will be discarded 
 * 					during new element insertion. 
 *
 *	ex: i/p : 5, 10, 15, 20, _, _
 *			x = 7 (element)
 *			i = 2 (position)
 *
 *		=> o/p: 5, 7, 10, 15, 20, _
 *
 *		i/p : 5, 7, 10, 20, _
 *			x = 3 (element)
 *			i = 2 (position)
 *
 *		=> o/p: 5, 7, 3, 10, 20
 *
 * -> Time complexity:	O(n)
 * 		-> Insertion at the beginning : 0(n)
 * 		-> Insertion at the end : 0(1)
 * 
 * -> Space complexity:	0(n) [includes the whole array]
 * -> Auxiliary space:  0(1) [additional storage elements]
 */
public class InsertElementsAtGivenIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int insertElement, position;

		int [] data1 = {5, 10, 15, 20, 0, 0};
		System.out.println("Array: "+Arrays.toString(data1));
		insertElement = 7; position = 2;
		System.out.println("Insert: "+insertElement+" at position: "+position);
		insertElement(data1, data1.length, 4, insertElement, position);
		System.out.println("Array: "+Arrays.toString(data1));
		
		int [] data2 = {5, 7, 10, 20, 0};
		System.out.println("\nArray: "+Arrays.toString(data2));
		insertElement = 3; position = 3;
		System.out.println("Insert: "+insertElement+" at position: "+position);
		insertElement(data2, data2.length, 4, insertElement, position);
		System.out.println("Array: "+Arrays.toString(data2));

		int [] data3 = {3, 5, 7, 9, 0};
		System.out.println("\nArray: "+Arrays.toString(data3));
		insertElement = 1; position = 1;
		System.out.println("Insert: "+insertElement+" at position: "+position);
		insertElement(data3, data3.length, 4, insertElement, position);
		System.out.println("Array: "+Arrays.toString(data3));
		
		int [] data4 = {2, 6, 8, 4, 0};
		System.out.println("\nArray: "+Arrays.toString(data4));
		insertElement = 10; position = 5;
		System.out.println("Insert: "+insertElement+" at position: "+position);
		insertElement(data4, data4.length, 4, insertElement, position);
		System.out.println("Array: "+Arrays.toString(data4));
		
		int [] data5 = {2, 6, 8, 4, 10};
		System.out.println("\nArray: "+Arrays.toString(data5));
		insertElement = 10; position = 5;
		System.out.println("Insert: "+insertElement+" at position: "+position);
		insertElement(data5, data5.length, 5, insertElement, position);
		System.out.println("Array: "+Arrays.toString(data5));
	}

	/**
	 * 
	 * @param data - array
	 * @param size - actual length of the array
	 * @param capacity - how many elements (non-default) are present
	 * @param insertElement - element to be inserted newly
	 * @param position - at which position new elements is to be inserted
	 * @return new / updated capacity
	 * base line : array must have some space for insertion
	 */
	private static int insertElement(int[] data, int size, int capacity, int insertElement, int position) {
		
		// if no place to insert new elements : no operation can be performed
		if(size <= capacity) {
			System.out.println("No empty space for insertion.");
			return capacity;
		}
		
		// check for position validity : no operation can be performed
		if(position > size) {
			System.out.println("Invalid position for insertion.");
			return capacity;
		}
		
		/* perform operation
		 * index starts from (size-2). So it means right 
		 * most element will be discarded.
		 */
		for(int index = (size-2); index >= (position-1); index--) {
			data[index+1] = data[index];
		}
		data[position-1] = insertElement;
		return (capacity+1);
	}

}
