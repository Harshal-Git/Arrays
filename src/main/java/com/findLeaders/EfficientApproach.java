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
 *	-> efficient approach 1 : start from last element; which will always be the leader. maintain last element as leader and traverse 
 *							towards left. if any element is found to be greater than current leader, change leader to new element.   
 *
 *	-> base line : this approach will print leaders but from right side OR in reverse. So separate DS would be needed to print 
 *					the elements in ascending order. 
 * 
 *	ex: 
 *		i/p : 7, 10, 4, 3, 6, 5, 2	==> o/p: 10 6 5 2
 *
 * 		i/p : 10, 20, 30 ==> o/p: 30
 * 
 * 		i/p : 30, 20, 10 ==> o/p: 30, 20, 10
 * 
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1) - for reverse / 0(n) - for storage to populate in proper order.
 */
public class EfficientApproach {

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
		int size = data.length;

		// right most element will always be leader
		int currentLeader = data[size-1];
		System.out.print(currentLeader+" ");

		// iterate over remaining elements on left
		for(int index = (size-2); index >= 0; index--) {
			if(currentLeader < data[index]) {
				currentLeader = data[index];
				System.out.print(currentLeader+" ");
			}
		}
	}
}
