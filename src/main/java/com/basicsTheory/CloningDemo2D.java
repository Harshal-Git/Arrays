/**
 * 
 */
package com.basicsTheory;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Cloning of 2D (/ multi dimension) arrays done via {@link java.lang.Object#clone() clone method.} by default 
 *		will share the elements between actual object & cloned object. Update in original array will be reflected in cloned. 
 *
 *	-> To solve that, all individual elements also needs to be cloned; which will make distinct elements (not shared).
 */
public class CloningDemo2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// initial array
		int [][] intA = new int[2][2];
		intA[0]= new int[] {1, 2};
		intA[1]= new int[] {3, 4};

		// shallow clone
		int [][] intB = intA.clone();

		// deep clone
		int [][] intC = new int[2][2];
		intC[0] = intA[0].clone();
		intC[1] = intA[1].clone();

		// print data before changing 
		printData("Before", intA, intB, intC);

		// update data in A
		intA[0][1] = 99;

		// print data after changing
		printData("After", intA, intB, intC);
	}

	/**
	 * @param string
	 * @param intA
	 * @param intB
	 * @param intC 
	 */
	private static void printData(String position, int[][] intA, int[][] intB, int[][] intC) {
		System.out.println("\nArrays "+position+": ");
		System.out.println("A: "+Arrays.toString(intA[0])+Arrays.toString(intA[1]));
		System.out.println("B: "+Arrays.toString(intB[0])+Arrays.toString(intB[1]));
		System.out.println("C: "+Arrays.toString(intC[0])+Arrays.toString(intC[1]));
	}
}
