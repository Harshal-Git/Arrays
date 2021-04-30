/**
 * 
 */
package com.shiftZeros;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> shift 0's of the array to the end of the array
 *
 *	-> standard approach: iterate through array and once we find any 0 element at ith position, using a secondary loop, 
 *							we find first non zero element at jth position; starting from the (i+1) position. 
 *
 *						Once we find, we will swap elements at i & j.   
 *
 *	ex: 
 *		i/p : 8, 5, 0, 10, 0, 20	=> o/p : 8, 5, 10, 20, 0, 0
 *
 *		i/p : 0, 0, 0, 10, 0	=> o/p : 10, 0, 0, 0, 0
 *
 *		i/p : 10, 20	=> o/p : 10, 20
 *	
 * -> Time complexity:	O(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {8, 5, 0, 10, 0, 20};
		System.out.println("Array : "+Arrays.toString(data1));
		shiftZeros(data1);
		System.out.println("Array after 0 shift: "+Arrays.toString(data1));

		int [] data2 = {0, 0, 0, 10, 0};
		System.out.println("\nArray : "+Arrays.toString(data2));
		shiftZeros(data2);
		System.out.println("Array after 0 shift: "+Arrays.toString(data2));
		
		int [] data3 = {5, 10, 15};
		System.out.println("\nArray : "+Arrays.toString(data3));
		shiftZeros(data3);
		System.out.println("Array after 0 shift: "+Arrays.toString(data3));
	}

	/**
	 * @param data - element array
	 */
	private static void shiftZeros(int[] data) {
		boolean swapped = false;
		for(int index = 0; index < data.length; index++) {
			// when we encounter any zero
			if(data[index] == 0) {
				swapped = false;
				// find immediate non-zero element starting from (index+1)
				for(int count = (index+1); count < data.length; count++) {
					// once we find any non-zero element : swap it with first 0
					if(!swapped && data[count] != 0) {
						swap(data, index, count);
						/*
						 * we just want to exchange first non-zero with first 0
						 * Once that swap is over, no further swaps should happen.
						 */
						swapped = true;
					}
				}
			}
		}
	}

	/**
	 * method to swap elements with given indexes 
	 * @param data
	 * @param index1
	 * @param index2
	 */
	private static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2]= temp;
	}
}
