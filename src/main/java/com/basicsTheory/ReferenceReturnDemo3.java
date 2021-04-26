/**
 * 
 */
package com.basicsTheory;

/**
 * @author Harshal-Git
 *
 *	-> Program to show difference between a mutable & immutable object passing in method arguments (*Demo2 & *Demo3)
 *
 *	-> As a mutable object "StringBuilder" will be considered. Reference of the method parameter of 
 *		such mutable object will reflect all operations on the actual object it is referring to. 
 */
public class ReferenceReturnDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Hello world");
		System.out.println("Builder data before: "+builder.toString());
		System.out.println("Hashcode before changeData(): "+builder.hashCode());
		changeData(builder);
		System.out.println("Builder data after: "+builder.toString());
		System.out.println("Hashcode after changeData(): "+builder.hashCode());
	}

	/**
	 * @param strData
	 * @param builder
	 */
	private static void changeData(StringBuilder builder) {
		System.out.println("--> Hashcode inside changeData() before append: "+builder.hashCode());
		builder.append(" new data");
		System.out.println("--> Hashcode inside changeData() after append: "+builder.hashCode());
	}
}
