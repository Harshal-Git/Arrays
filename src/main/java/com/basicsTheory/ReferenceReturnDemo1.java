/**
 * 
 */
package com.basicsTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harshal-Git
 *
 * -> Program to check whether array object OR collection is required to be returned 
 *	  from a method after passing it as a parameter and processing on it.
 *
 * -> In such cases; no need to return it from that method; because these calls are pass by reference; 
 * 	  which will pass a copy of the reference which is pointing that object in heap. And any process done
 * 	  via that copy reference; will actually be reflected on the original object in heap.
 * 
 * -> That's why Java is "Pass by value" (for primitives) and "Pass by Reference" for objects (array/collection/custom objects).  
 */
public class ReferenceReturnDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int data[] = new int[5];
		data[0] = 1; data[1] = 2; data[2] = 3; data[3] = 4; data[4] = 5;
		System.out.println("Array Data: "+Arrays.toString(data));
		System.out.println("Calling add1VoidReturn() on array...");
		add1VoidReturn(data);
		System.out.println("Array after add1VoidReturn(): "+Arrays.toString(data)+"\n");

		// passing an array list
		List<Integer> al = new ArrayList<>();
		al.add(11);al.add(12);al.add(13);al.add(14);al.add(15);
		System.out.println("Array list: "+al.toString());
		System.out.println("Calling add2VoidReturn() on array list...");
		add2VoidReturn(al);
		System.out.println("Array list after add2VoidReturn(): "+al.toString());
	}

	/**
	 * method which has void return & accepts a list object as an argument
	 * @param al : array list 
	 */
	private static void add2VoidReturn(List<Integer> al) {
		int existingElement= -1;
		for(int index = 0; index < al.size(); index++) {
			existingElement= (al.get(index)+2);
			al.set(index, existingElement);
		}
	}

	/**
	 * method which has void return & accepts an array as an argument
	 * @param array - array
	 */
	private static void add1VoidReturn(int[] array) {
		for(int index = 0; index < array.length; index++) {
			array[index]++;
		}
	}
}
