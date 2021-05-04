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
 * 	-> naive approach:	for each element, count the same element array & if it becomes more than n/2; return that index.
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
		int foundIndex = -1;
		int size = data.length;
		int frequency = 0;

		// iterate over all elements
		for(int index = 0; index < size; index++) {

			// reset frequency for new element
			frequency = 0;

			// count frequency of current element
			for(int count = 0; count < size; count++) {
				if(data[index] == data[count]) {
					frequency++;	
				}
			}
			// if element becomes a majority element
			if(frequency > (size/2)) {
				foundIndex = index; 
				break;	// if we don't use break, it will populate last index of the majority element (if any)
			}
		}
		return foundIndex;
	}

}