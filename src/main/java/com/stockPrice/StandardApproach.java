/**
 * 
 */
package com.stockPrice;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Stock price are given in an array. Find max profit can be achieved by buy & sell of stocks.
 *
 * 	-> this is the only implementation I understood. Base line - find and keep adding the differences between 2 consecutive
 * 		price such that it gives profit.
 * 
 *  -> ex:
 *  		i/p : 1, 5, 3, 8, 12 ==> o/p : 13 (Buy on 1 & Sell on 5 + Buy on 3 & Sell on 12)
 *  
 *  		i/p : 30, 20, 10 ==> o/p : 0 (no gain as price is decreasing on all days)
 *  
 *  		i/p : 10, 20, 30 ==> o/p : 20 (Buy on 10 & Sell on 20 + Buy on 20 & Sell on 30)
 *  
 *  		i/p : 1, 5, 3, 1, 2, 8 ==> o/p : 11 (Buy on 1 & Sell on 5 + Buy on 1 & Sell on 8)
 *  
 * -> Time complexity: 0(n) - single pass for all price of given array	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 5, 3, 8, 12};
		System.out.println("Array: "+Arrays.toString(data1)+" --> Max profit: "+getMaxProfit(data1));
		
		int [] data2 = {30, 20, 10};
		System.out.println("Array: "+Arrays.toString(data2)+" --> Max profit: "+getMaxProfit(data2));
		
		int [] data3 = {10, 20, 30};
		System.out.println("Array: "+Arrays.toString(data3)+" --> Max profit: "+getMaxProfit(data3));
		
		int [] data4 = {1, 5, 3, 1, 2, 8};
		System.out.println("Array: "+Arrays.toString(data4)+" --> Max profit: "+getMaxProfit(data4));
	}

	/**
	 * @param data - stock price array elements
	 * @return - max profit
	 */
	private static int getMaxProfit(int[] data) {
		int maxProfit = 0;
		for(int index = 1; index < data.length; index++) {
			if(data[index] > data[index-1]) {
				maxProfit += (data[index] - data[index-1]);
			}
		}
		return maxProfit;
	}
}
