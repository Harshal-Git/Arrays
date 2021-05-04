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
 * 	-> naive approach: as per the baseline above, we will calculate max element @ left & max element @ right of each of the
 * 						intermediate element. The max water level will be minimum value of both. And to get actual storage, 
 * 						existing element needs to be subtracted from the min of left most & right most. 
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
 * -> Time complexity:	0(n^2)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class NaiveApproach {

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
		
		// calculate left max & right max for each element
		int leftMax, rightMax;
		
		// iterate over all intermediate elements and find left & right max
		for(int index = 1; index < (size-1); index++) {
			
			// prepare left max for each element
			leftMax = data[index];
			for(int count= 0; count < index; count++) {
				if(data[count] > leftMax) {
					leftMax = data[count];
				}
			}
			
			// prepare right max for each element
			rightMax = data[index];
			for(int count = (size-1); count > index; count--) {
				if(data[count] > rightMax) {
					rightMax = data[count];
				}
			}
			//System.out.println("Data: "+data[index]+" --> left max: "+leftMax+" --> right max: "+rightMax);
			waterLevel += (findMin(leftMax, rightMax) - data[index]);
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
