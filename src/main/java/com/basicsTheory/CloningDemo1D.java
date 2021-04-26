/**
 * 
 */
package com.basicsTheory;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Cloning of 1D arrays doesn't share the elements.
 *		Update in one is not reflected in another. 
 */
public class CloningDemo1D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// initial array
		int [] intA = new int[3];
		intA[0]= 1;
		intA[1]= 2;
		intA[2]= 3;

		// clone
		int [] intB = intA.clone();
		printData("Before", intA, intB);

		// update data in A
		intA[2] = 99;

		// print both arrays again
		printData("After", intA, intB);
	}

	/**
	 * @param string
	 * @param intA
	 * @param intB
	 */
	private static void printData(String position, int[] intA, int[] intB) {
		System.out.println("\nArrays "+position+": ");
		System.out.println("A: "+Arrays.toString(intA));
		System.out.println("B: "+Arrays.toString(intB));
	}
}
