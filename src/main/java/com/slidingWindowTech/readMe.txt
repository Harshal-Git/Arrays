Variations for this sliding window problem:


1. Specific window size is given and then we are asked to find max / min sum of sub arrays with that window.

	In this case, as we have specific window size to work; it doesn't matter what type of numbers it has. (Negative/Positive) 
	
	ex: PrintMaxSumAP1.java / PrintMaxSumAP2.java 

####

2. A specific sum is given and we are asked to find whether any sub array exist with such sum. 

	2:a. If we are given non-negative integers only; then sliding window solution can be used for 0(n) time.
		
	ex: FindSubArrayExistAP1.java
	
	2:b. If we are given any natural number, sliding window solution will not work. For that; naive approach will have to be used.
	
####
	
3. N-bonacci number: (practice problem - pending)
	
	Fibonacci series prepares every element by taking 2 previous elements. There can be a variation in which the number of 
	previous elements to refer can be provided via input. 
	
	ex:
	
		i/p : n = 3, m = 8 (take 3 previous elements & prepare series up to 8 elements)
		
		=> o/p : 0 0 1 1 2 4 7 13
		
		i/p : n = 4, m = 10 (take 4 previous elements & prepare series up to 10 elements)
		
		=> o/p : 0 0 0 1 1 2 4 8 15 29
		
####

4. Count distinct elements in every window of size 'k' from given array. (using hashing + sliding window) (practice problem - pending)

	i/p: {1, 2, 1, 3, 4, 3, 3}	& k = 4
		
	=> o/p : 3 4 3 2	( window1(1/2/3), window2(2/1/3/4), window3(1/3/4), window4(3/4) )
		 