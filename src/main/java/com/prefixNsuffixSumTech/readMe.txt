Practice problems:

1. Check if given array can be divided into 3 parts with equal sum.

	ex: {5, 2, 6, 1, 1, 1, 5}	==> Yes [(5+2) == (6+1) == (1+1+5)]
	
	
[IMP]	
2. Check if there is any sub array with 0 sum.

	ex: {6, 4, -2, -2, 8}	==> Yes : {4, -2, -2}

2.a: Print those sub arrays.

3. Find the longest sub array (length of the sub array) with equal number of 0s & 1s for a given binary array.
	  
	ex: {0, 0, 0, 1, 1, 0, 0, 0, 0, 1}	==> 
	
		Answer: 4		Range(1, 4) = 0 0 1 1
						Range(2, 5) = 0 1 1 0
						Range(3, 6) = 1 1 0 0 