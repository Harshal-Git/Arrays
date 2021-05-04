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
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 1, 0, 0, 0, 1};
		System.out.print("Arrays: "+Arrays.toString(data1));
		printMinimumFlips(data1);
		
		/*int [] data2 = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
		System.out.print("\nArrays: "+Arrays.toString(data2));
		printMinimumFlips(data2);*/
		
	}

	/**
	 * @param data - data elements
	 */
	private static void printMinimumFlips(int[] data1) {

		
		
	}

}
