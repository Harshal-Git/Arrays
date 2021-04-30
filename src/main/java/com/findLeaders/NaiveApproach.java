/**
 * 
 */
package com.findLeaders;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> print leaders in the given array (sorted OR unsorted array)
 *
 *	-> leader elements are the elements for which all elements to the right side are smaller than the element itself.
 *
 *	-> naive approach : iterate over all elements and for each element, check whether the elements on the right 
 *						are always smaller than the element itself. 
 *
 *	ex: 
 *		i/p : 7, 10, 4, 3, 6, 5, 2	==> o/p: 10 6 5 2
 *
 * 		i/p : 10, 20, 30 ==> o/p: 30
 * 
 * 		i/p : 30, 20, 10 ==> o/p: 30, 20, 10
 * 
 * -> Time complexity:	0(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {7, 10, 4, 3, 6, 5, 2};
		System.out.print("Array: "+Arrays.toString(data1)+" --> Leaders: ");
		printLeaders(data1);

		int [] data2 = {10, 20, 30};
		System.out.print("\nArray: "+Arrays.toString(data2)+" --> Leaders: ");
		printLeaders(data2);

		int [] data3 = {30, 20, 10};
		System.out.print("\nArray: "+Arrays.toString(data3)+" --> Leaders: ");
		printLeaders(data3);

		int [] data4 = {7, 10, 4, 10, 6, 5, 2};
		System.out.print("\nArray: "+Arrays.toString(data4)+" --> Leaders: ");
		printLeaders(data4);
	}

	/**
	 * @param data - array elements
	 */
	private static void printLeaders(int[] data) {
		boolean isLeader = true;
		int index, count;
		int size = data.length;
		for(index = 0; index < size; index++) {
			isLeader = true;
			for(count = (index+1); count < size; count++) {
				if(data[index] <= data[count]) {
					isLeader = false;
					break;
				}
			}
			if(isLeader) {
				System.out.print(data[index]+" ");
			}
		}
	}
}
