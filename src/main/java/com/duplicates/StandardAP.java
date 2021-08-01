/**
 * 
 */
package com.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harshal-Git
 *
 *	-> WAS ASKED IN OLA - MONEY
 *
 *	-> Print the element occurring more than once in given array.
 *
 *	Analysis : only for printDuplicateElements() method
 * -> Time complexity:	0(n) 
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1) [if instead of returning list; we print elements directly]
 * 
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data = null;

		// case 1
		data = new int[]{3, 3, 4, 5, 5, 1, 2, 2};
		printMessage(data);

		// case 2
		data = new int[]{4, 5, 5, 1, 1, 2, 3, 3};
		printMessage(data);

		// case 3
		data = new int[]{3, 3, 4, 5, 1, 2};
		printMessage(data);

		// case 4
		data = new int[]{1, 2, 3, 4, 5};
		printMessage(data);

		// case 5
		data = new int[]{1, 1, 1};
		printMessage(data);

		// case 5
		data = new int[]{1, 1, 2, 2, 3, 3, 4, 4};
		printMessage(data);

		// case 6
		data = new int[]{0, 6, 6, 8, 8, 8, 2, 4, 4, 3, 7, 7};
		printMessage(data);

		// case 7
		data = new int[]{0, 6, 6, 8, 4, 4, 3, 7, 7, 8};
		printMessage(data);

		// case 8
		data = new int[]{4, 5, 5, 3, 3, 1, 1, 2, 3, 3};
		printMessage(data);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		if(data == null) {
			return;
		} 
		System.out.println("\nArray: "+Arrays.toString(data));
		List<Integer> singnals = printDuplicateElements(data);
		printSignalProcessing(singnals);
	}

	/**
	 * @param singnals
	 */
	private static void printSignalProcessing(List<Integer> singnals) {
		System.out.print("Unique elements: "+singnals.toString()+"\nSignals: ");
		int size = singnals.size();
		int prevElement = -1;
		if(size >= 1) {
			System.out.print("1 ");
			prevElement = singnals.get(0);
		}
		// process remaining elements
		for(int i = 1; i < singnals.size(); i++) {
			if(singnals.get(i) < prevElement) {
				System.out.print("-1 ");
			} else {
				System.out.print("1 ");
			}
		}
		System.out.println();
	}

	/**
	 * method to find list of repeating elements from given array 
	 * @param data - array element data
	 * @return - list of integers; which occurred more than once in the array
	 */
	private static List<Integer> printDuplicateElements(int[] data) {
		List<Integer> signals = new ArrayList<>();
		// set first element as repeated element
		int lastRepeatedIndex = 0;
		int index = 1;
		int size = data.length;
		int count = 1;

		// iterate over remainign elements
		while(index < size) {
			// if current & last repeated element matches
			if(data[index] == data[lastRepeatedIndex]) {
				count++;
			} else {
				// if current & last repeated element doesn't match
				if(count > 1) {
					// if previously calculated repeated elements occured more than once
					signals.add(data[lastRepeatedIndex]);
				}
				// otherwise replace last repeated index
				lastRepeatedIndex = index;
				// reset the counter
				count = 1;
			}
			// pick next element
			index++;
		}
		// if last repeated element is left out
		if(count > 1) {
			signals.add(data[size-1]);
		}
		return signals;
	}
}
