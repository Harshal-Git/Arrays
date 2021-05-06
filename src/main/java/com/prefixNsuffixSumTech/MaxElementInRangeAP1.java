/**
 * 
 */
package com.prefixNsuffixSumTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harshal-Git
 *
 *	-> 2 arrays given Left & Right points. Elements at same index in both arrays represents a whole range of numbers between them 
 *		including range elements also.
 *		
 *		We need to find max occurring element from all those ranges.
 *
 *	ex:
 *		L = {1, 2, 5, 15}; R = {5, 8, 7, 18}	(In general Left range element @ i <= right range element @ i)
 *
 *		o/p => 5
 *
 *		Range1 = {1, 2, 3, 4, 5}, Range2 = {2, 3, 4, 5, 6, 7, 8}, 
 *		Range3 = {5, 6, 7}, Range4 = {15, 16, 17, 18}	=> max occurring element in all ranges is 5
 *
 *  -> naive solution : iterate through all ranges & count frequency of all elements. use hashing to store this frequency.
 *  					at the end, return element with highest frequency. 
 *
 * -> Time complexity:	O(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 */
public class MaxElementInRangeAP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] leftRange1 = {1, 2, 3};
		int [] rightRange1 = {3, 5, 7};
		printMessage(leftRange1, rightRange1);

		int [] leftRange2 = {1, 2, 5, 15};
		int [] rightRange2 = {5, 8, 7, 18};
		printMessage(leftRange2, rightRange2);
	}

	/**
	 * @param leftRange
	 * @param rightRange
	 */
	private static void printMessage(int[] leftRange, int[] rightRange) {
		System.out.println("\nLeft range: "+Arrays.toString(leftRange));
		System.out.println("Right range: "+Arrays.toString(rightRange));
		System.out.println("Max occurring element: "+findMaxOccurringElement(leftRange, rightRange));
	}
	
	/**
	 * @param leftRange
	 * @param rightRange
	 * @return
	 */
	private static int findMaxOccurringElement(int[] leftRange, int[] rightRange) {

		Map<Integer, Integer> frequencyMap = new HashMap<>();
		int size = leftRange.length;

		// iterate over all range elements
		for(int index = 0; index < size; index++) {
			// prepare numbers starting from left range till right range including the ranges
			for(int range = leftRange[index]; range <= rightRange[index]; range++) {
				// if element doesn't exist in the map; add newly
				if(!frequencyMap.containsKey(range)) {
					frequencyMap.put(range, 1);
				} else {
					// if element exist; increment existing frequency
					int freq = frequencyMap.get(range);
					frequencyMap.put(range, (++freq));
				}
			}
		}
		// find max frequency element from given map
		return maxOccurringElement(frequencyMap);
	}

	/**
	 * method to sort given frequency map via by it's values
	 * @param frequencyMap
	 * @return
	 */
	private static int maxOccurringElement(Map<Integer, Integer> frequencyMap) {

		// prepare list of entry set
		List<Map.Entry<Integer, Integer>> entrySetList = new ArrayList<>(frequencyMap.entrySet());

		// sort entry set list by it's value 
		Collections.sort(entrySetList, (obj1, obj2) -> {
			return obj2.getValue().compareTo(obj1.getValue());
		});

		// fill the data in new linked hash map (linkedhashmap only will maintain the sorted order of key-set)
		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<Integer, Integer> entrySet : entrySetList) {
			sortedMap.put(entrySet.getKey(), entrySet.getValue());
		}
		//System.out.println("SortedMap: "+sortedMap.toString());

		// return key of first entry set list
		return entrySetList.get(0).getKey();
	}
}
