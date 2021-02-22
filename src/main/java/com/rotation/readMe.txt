Requirements for array rotation:

A - array
n - length of the array
d - positions to shift

#########

package: com.rotation.rotationBased

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

package: com.rotation.rotationBased

5. Find the lowest element OR rotation count from given sorted & rotated array:

	https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
	
	Demo: FindLowestElementAp1.java / FindLowestElementAp2.java 							
		
	Important: The approach#2 includes a method; which can be used to find a pivot element for sorted + rotated array 
				with reference of binary search. Pivot element: Index of the lowest element. 
	
6. Search an element in a sorted and rotated array:

	https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	
	Demo: SearchInRotatedAp1.java
	
7. 	Given a sorted and rotated array, find if there is a pair with a given sum. (start)

	https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/