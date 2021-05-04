/*
 * 
 */
package com.findMajorityElement;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find majority element (having count > (n/2)) OR max occurring element. Return index of that element.
 *
 * 	-> efficient approach:	it's called Boyer–Moore majority vote algorithm. It has 2 phase:
 * 
 * 	P#1 : find a candidate which can be relied as majority element and note it's index.
 * 	P#2 : check frequency in the array for the element same as candidate element 
 * 			and if it's greater than (n/2); return the candidate index. Otherwise return -1 (no majority element found)	
 * 		
 * 	ex:
 * 		i/p: {8, 3, 4, 8, 8}  -> o/p: 0 / 3 / 4 (index of 8)
 * 
 * 		i/p: {3, 7, 4, 7, 7, 5}  -> o/p: -1 (no element count > 3)
 * 
 * 		i/p: {20, 30, 40, 50, 50, 50, 50}  -> o/p: 3 / 4 / 5 / 6 (index of 50) 
 *
 * 		i/p: {8, 7, 6, 8, 6, 6, 6, 6}  -> o/p: 2 / 4 / 5 / 6 / 7 (index of 6)
 * 		 
 * -> Time complexity:	O(n) + O(n) = O(2n) ~ O(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {8, 3, 4, 8, 8};
		System.out.println("Array: "+Arrays.toString(data1)+" --> Majority element @ : "+findMajority(data1));

		int [] data2 = {3, 7, 4, 7, 7, 5};
		System.out.println("\nArray: "+Arrays.toString(data2)+" --> Majority element @ : "+findMajority(data2));

		int [] data3 = {20, 30, 40, 50, 50, 50, 50};
		System.out.println("\nArray: "+Arrays.toString(data3)+" --> Majority element @ : "+findMajority(data3));

		int [] data4 = {8, 7, 6, 8, 6, 6, 6, 6};
		System.out.println("\nArray: "+Arrays.toString(data4)+" --> Majority element @ : "+findMajority(data4));

		int [] data5 = {6, 8, 4, 8, 8};
		System.out.println("\nArray: "+Arrays.toString(data5)+" --> Majority element @ : "+findMajority(data5));
		
		int [] data6 = {6, 8, 7, 6, 6};
		System.out.println("\nArray: "+Arrays.toString(data6)+" --> Majority element @ : "+findMajority(data6));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findMajority(int[] data) {

		int size = data.length;

		// find a candidate
		int candidateIndex = findCandidateIndex(data);

		// check if given candidate is majority element?
		int count = 0;
		for(int index = 0; index < size; index++) {
			if(data[index] == data[candidateIndex]) {
				count++;
			}
		}
		// check for majority element : exist OR not?
		if(count <= (size/2)) {
			return -1;
		} else {
			return candidateIndex;	
		}
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findCandidateIndex(int[] data) {
		int count = 1;
		
		// make initial element as candidate
		int candidateIndex = 0;
		int size = data.length;

		// iterate over all remaining elements to find whether that element is same as candidate OR not
		for(int index = 1; index < size; index++) {
			// if current element is same as candidate element; increment count
			if(data[index] == data[candidateIndex]) {
				count++;
			} else {
				// otherwise decrement count
				count--;
			}
			// if count becomes 0, change the candidate index & reset count
			if(count == 0) {
				candidateIndex = index;
				count = 1;
			}
		}
		// return the candidate index
		return candidateIndex;
	}

}