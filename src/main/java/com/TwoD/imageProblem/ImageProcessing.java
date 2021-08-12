/**
 * 
 */
package com.TwoD.imageProblem;

/**
 * @author Harshal-Git
 *
 *	Was asked in TESCO.
 *	
 */
public class ImageProcessing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] image1 = {
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 0, 0, 0, 1},
				{1, 1, 1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1}
		};

		int[][] image2 = {
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0}
		};

		int[][] image3 = {
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 0, 0}
		};

		int[][] image4 = {
				{0, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1}
		};

		int[][] image5 = {
				{0}
		};

		String result = null;

		// image 1
		result = printCoordinates(image1);
		System.out.println("Result Image 1: "+result);

		// image 2
		result = printCoordinates(image2);
		System.out.println("Result Image 2: "+result);

		// image 3
		result = printCoordinates(image3);
		System.out.println("Result Image 3: "+result);

		// image 4
		result = printCoordinates(image4);
		System.out.println("Result Image 4: "+result);

		// image 5
		result = printCoordinates(image5);
		System.out.println("Result Image 5: "+result);
	}

	public static String printCoordinates(int [][] image){
		StringBuilder builder = new StringBuilder();
		if(image == null){
			return null;
		}
		//System.out.println("inside method");
		int rowSize = image.length;
		int colSize = image[0].length;
		int row = 0, col = 0;
		boolean innerBreak = false;
		// start coordinate
		while(row < rowSize) {
			col = 0;
			while(col < colSize){
				if(image[row][col] == 0){
					//System.out.print((row)+","+(col)+" ");  // start coordinate printed
					builder.append(row).append(",").append(col).append(" ");
					innerBreak = true;
					break;  
				}
				col++;
			}
			// if inner stops; stop outer also
			if(innerBreak){
				break;
			} else{
				row++;  
			}
		}

		// if image has no 0s
		if(row == (rowSize-1) && col == (colSize-1)){
			//System.out.println((row)+","+(col)+" ");
			builder.append(row).append(",").append(col).append(" ");
			return builder.toString();
		}

		// end coordinate
		int endRowCoordinate = -1;
		int endColCoordinate = -1;
		while(row < rowSize)  {
			col = row;
			while(col < colSize) {
				if(image[row][col] == 0){
					endRowCoordinate = row;
					endColCoordinate = col;
				}
				col++;  
			}
			row++;
		}
		if(endRowCoordinate != -1 && endColCoordinate != -1){
			//System.out.println((endRowCoordinate)+","+(endColCoordinate));
			builder.append(endRowCoordinate).append(",").append(endColCoordinate).append(" ");
		}
		return builder.toString();
	}
}
