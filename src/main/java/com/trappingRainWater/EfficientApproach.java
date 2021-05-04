/**
 * 
 */
package com.trappingRainWater;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find total water storage possible with given heights of bars
 *
 * 	-> base line : from the given array, no water can be stored on the right most OR left most bars as there is nothing 
 * 					to hold water after those points. So all calculation will happen with the intermediate elements always.
 *
 * 	-> efficient approach: pre-compute left max and right max for all elements and then for all intermediate elements; 
 * 							use below formula to calculate possible water storage.  
 * 
 * 	-> so formula for water storage s[i]= min(leftMax(i), rightMax(i)) - data[i]
 * 
 * 		i/p : 2, 0, 2 ==> o/p : 2 (max height of the wall can be 2 & water can be filled in the mid area of 2 units 
 * 									where there is no wall)
 * 
 * 		i/p : 3, 0, 1, 2, 5 ==> o/p : 6 (max water can be filled till the height of 3 & then all middle area can be filled with 
 * 										water for 6 units)
 * 
 * 		i/p : 1, 2, 3 ==> o/p : 0 (no water can be filled as it will run away)
 * 
 * 		i/p : 3, 2, 1 ==> o/p : 0 (no water can be filled as it will run away)
 * 
 * 		i/p : 5, 0, 6, 2, 3 ==> o/p : 6 
 * 
 * -> Time complexity:	0(n) + 0(n) + 0(n) = 0(3n) ~ 0(n)
 * -> Space complexity:	0(n) + 0(n) = 0(2n) ~ 0(n)
 * -> Auxiliary space:  0(n) + 0(n) = 0(2n) ~ 0(n)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {3, 0, 1, 2, 5};
		System.out.println("Bar heights: "+Arrays.toString(data1)+" ==> Max water filled: "+findMaxWaterFilled(data1)+"\n");

		int [] data2 = {2, 0, 2};
		System.out.println("Bar heights: "+Arrays.toString(data2)+" ==> Max water filled: "+findMaxWaterFilled(data2)+"\n");

		int [] data3 = {5, 0, 6, 2, 3};
		System.out.println("Bar heights: "+Arrays.toString(data3)+" ==> Max water filled: "+findMaxWaterFilled(data3)+"\n");

		int [] data4 = {1, 2, 3};
		System.out.println("Bar heights: "+Arrays.toString(data4)+" ==> Max water filled: "+findMaxWaterFilled(data4)+"\n");

		int [] data5 = {9, 8, 7};
		System.out.println("Bar heights: "+Arrays.toString(data5)+" ==> Max water filled: "+findMaxWaterFilled(data5)+"\n");
		
		int [] data6 = {6, 4, 2};
		System.out.println("Bar heights: "+Arrays.toString(data6)+" ==> Max water filled: "+findMaxWaterFilled(data6)+"\n");
	}

	/**
	 * @param data - bar heights array
	 * @return
	 */
	private static int findMaxWaterFilled(int[] data) {
		int waterLevel = 0;
		int size = data.length;
		int [] leftMax = new int[size];
		int [] rightMax = new int[size];

		// calculate left max for all elements
		int leftMaxElement = data[0];
		leftMax[0] = leftMaxElement;
		for(int index = 1; index < size; index++) {
			if(leftMaxElement < data[index]) {
				leftMaxElement = data[index];
			}
			leftMax[index] = leftMaxElement;
		}

		// calculate right max for all elements
		int rightMaxElement = data[size-1];
		rightMax[size-1] = rightMaxElement;
		for(int index = (size-2); index >= 0; index--) {
			if(rightMaxElement < data[index]) {
				rightMaxElement = data[index];
			}
			rightMax[index] = rightMaxElement;
		}

		// apply water storage calculation formula for all intermediate elements
		for(int index = 1; index < (size-1); index++) {
			waterLevel += (findMin(leftMax[index], rightMax[index]) - data[index]);
		}
		return waterLevel;
	}

	/**
	 * @param leftMax
	 * @param rightMax
	 * @return
	 */
	private static int findMin(int leftMax, int rightMax) {
		return ((leftMax < rightMax) ? (leftMax) : (rightMax));
	}
}
