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
 *	-> efficient approach: iterate through array and keep storing an index of last Non-0 element read.
 *							If ever 0 is encountered, swap that element with index of non-0 element.    
 *
 * -> Time complexity:	O(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class EfficientApproach {

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
	 * @param data - data  
	 */
	private static void shiftZeros(int[] data) {
		int nonZeroIndex = 0;
		for(int index = 0; index < data.length; index++) {
			if(data[index] != 0) {
				swap(data, index, nonZeroIndex);
				nonZeroIndex++;
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
