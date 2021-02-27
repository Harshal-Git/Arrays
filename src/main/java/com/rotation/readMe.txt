Requirements for array rotation:

A - array
n - length of the array
d - positions to shift

#########

package: com.rotation.lowest

1. Reverse array method 

	Demo: ReverseAlgoLS.java / ReverseAlgoRS.java 
	
2. Temp array method (using additional array)

	Demo: TempArrayLS.java / TempArrayRS.java 
		
3. By doing single shift / Cyclic rotation : d times
	
	Shift existing array by 1 position (left OR right); and repeat it for d times.
	
	Demo: CyclicLS.java / CyclicRS.java 
	
4. Block swap algo: (Skipped - complexity same as Reverse method)
	
	https://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/

#########

package: com.rotation.lowest

1. Find the lowest element OR rotation count from given sorted & rotated array:

	https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
	
	Demo: FindLowestElementAp1.java / FindLowestElementAp2.java 							
		
	Important: The approach#2 includes a method; which can be used to find a pivot element for sorted + rotated array 
				with reference of binary search. Pivot element: Index of the lowest element. 
	
2. Search an element in a sorted and rotated array:

	https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	
	Demo: SearchInRotatedAp1.java
	
3. Search second lowest element: [PENDING]
	
	
	
#########
	
7. 	Given an array & find if there is a pair with a given sum. (start)

	https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
	https://www.geeksforgeeks.org/given-two-unsorted-arrays-find-pairs-whose-sum-x/
	https://www.geeksforgeeks.org/count-pairs-with-given-sum/
	https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
	
	Demo: FindSumPairAp1.java / FindSumPairAp2.java / FindSumPairAp3.java
	
	For Sorted + Rotated array
	
	https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/