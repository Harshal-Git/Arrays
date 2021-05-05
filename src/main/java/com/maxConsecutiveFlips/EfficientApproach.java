/**
 * 
 */
package com.maxConsecutiveFlips;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> for a given binary array, make all elements same with minimum flips (0 -> 1 or 1 -> 0). and print those flip positions.
 *		all elements can be either 0 or 1 in the result.
 *
 * 	-> base line: flips can happen for consecutive elements only. 
 * 
 * 	ex:
 * 		i/p : {1, 1, 0, 0, 0, 1}	=> o/p : From 2 to 4
 * 
 * 		i/p : {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1}	=> o/p : From 1 to 3
 * 														 From 5 to 6
 * 
 * 		i/p : {1, 1, 1}	=> o/p : (blank) 
 * 
 *  	i/p : {0, 1}	=> o/p : From 0 to 1 (OR) From 1 to 1
 *  
 * -> Time complexity:	O(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 1, 0, 0, 0, 1};
		System.out.println("Arrays: "+Arrays.toString(data1));
		printMinimumFlips(data1);

		int [] data2 = {1, 1, 0, 0, 0, 1, 0};
		System.out.println("\nArrays: "+Arrays.toString(data2));
		printMinimumFlips(data2);

		int [] data3 = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
		System.out.println("\nArrays: "+Arrays.toString(data3));
		printMinimumFlips(data3);

		int [] data4 = {1, 1, 1};
		System.out.println("\nArrays: "+Arrays.toString(data4));
		printMinimumFlips(data4);

		int [] data5 = {1, 0};
		System.out.println("\nArrays: "+Arrays.toString(data5));
		printMinimumFlips(data5);

		int [] data6 = {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1};
		System.out.println("\nArrays: "+Arrays.toString(data6));
		printMinimumFlips(data6);

		int [] data7 = {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0};
		System.out.println("\nArrays: "+Arrays.toString(data7));
		printMinimumFlips(data7);

		int [] data9 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1};
		System.out.println("\nArrays: "+Arrays.toString(data9));
		printMinimumFlips(data9);

		int [] data10 = {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0};
		System.out.println("\nArrays: "+Arrays.toString(data10));
		printMinimumFlips(data10);
	}

	/**
	 * @param data - data elements
	 */
	private static void printMinimumFlips(int[] data) {

		int size = data.length;

		// iterate over elements (skipping first)
		for(int index = 1; index < size; index++) {

			// if current character is not same as previous : this will be a new group
			if(data[index-1] != data[index]) {

				/*
				 * If current element is not same as first element : it's a start 
				 * of a new group. Then flipping also should start from this point.
				 */
				if(data[index] != data[0]) {
					System.out.print("From: "+index+" to ");
				} else {
					/*
					 * If current element is same as first element, it means that the 
					 * previous position was the end of a group. So flipping should 
					 * have stopped at previous index.
					 */
					System.out.println((index-1));
				}
			}
		}
		// if the group has difference of 1; this print will be needed
		// not to leave the end index blank
		if(data[size-1] != data[0]) {
			System.out.println((size-1));
		}
	}

}
