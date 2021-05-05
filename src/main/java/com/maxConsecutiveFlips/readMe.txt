On what basis the efficient approach works?

-> For any binary number, there can be only 2 possibilities:

	1. The groups of 1s & 0s will have difference of 1. (+/- 1). So group having lower count should be flipped. 
		
		[A GROUP WILL HAVE 1 OR MORE CHARACTERS. FLIP OF ALL CHARACTERS IN A SINGLE GROUP MUST HAPPEN SIMULTENEOUSLY.]
	
		ex: 
			1 1 0 0 0 1 1 1 0 0 1	=> 3 groups of 1 & 2 groups of 0
		 
			0 0 1 1 0 0 0 1 1 0 0 	=> 3 groups of 0 & 2 groups of 1
			
			1 1 1 1 				=> 1 group of 1 & 0 group of 0
			
			0 0 0 0 				=> 1 group of 0 & 0 group of 1
			
	So if first and last characters are not same; it will have difference of (+/- 1).
	  
	2. The groups of 1s & 0s will have no difference. So any group can be flipped.
	
		ex: 
			0 0 1 1 1 0 0 0 0 1 1	=> 2 groups of both 0 & 1
		 
			1 1 0 0 0 0 1 1 1 1 0	=> 2 groups of both 0 & 1
			
	Here first and last character are same, so difference will be 0 always.

-> Hence to find the lowest possible flips in general, it's always the characters in second group. Start flipping those 
	characters; and thus we will have lowest OR same flips as per any case above.
	
##########
	
-> During iteration, when we want to know whether any group is started OR ending, it can be done via comparing 
	respective character with first character.
	 
	If it's not same as first character, then it's a new group start. 
	If it's same, then just before that position, a group has ended. 