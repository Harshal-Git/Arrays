Available approaches for array rotation:

A - array
n - length of the array
d - positions to shift

#####

1. Reverse array method [CHECK : is right shift possible?]

	reverse(A, 0, (d-1)) : reverse partial array from 0 --> (d-1)
	reverse(A, d, (n-1)) : reverse partial array from d --> (n-1)
	reverse(A, 0, (n-1)) : reverse complete array from 0 --> (n-1)
	
	Demo: Approach1.java (left shift)
	
2. Temp array method (using additional array)

	transfer data from main array (A) to new array (B) with a formula to 
	calculate new index based on array length & shift position
	
	Demo: Approach2.java (left shift)
	Demo: Approach3.java (right shift)
		
3. By doing single shift : d times
	
	Shift existing array by 1 position (left OR right); and repeat it for d times.
	
	Demo: Approach4.java (left shift)
	Demo: Approach5.java (right shift)
	
4. Block swap algo: 
	
	https://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/

	Demo: Approach6.java
	