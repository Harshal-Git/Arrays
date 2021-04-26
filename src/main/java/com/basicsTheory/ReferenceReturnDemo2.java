/**
 * 
 */
package com.basicsTheory;

/**
 * @author Harshal-Git
 *
 *	-> Program to show difference between a mutable & immutable object passing in method arguments (*Demo2 & *Demo3)
 *
 *	-> As immutable, "String" is considered.
 *
 *	-> Immutable will never change the data. Once reference of it passed to the method & if any operation is performed;
 *		a new object will be created; which will not change the older object passed in method argument.  
 *
 */
public class ReferenceReturnDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strData = "hello";
		System.out.println("String before: "+strData);
		System.out.println("Hashcode before changeData(): "+strData.hashCode());
		changeData(strData);
		System.out.println("String after: "+strData);
		System.out.println("Hashcode after changeData(): "+strData.hashCode());
	}

	/**
	 * @param strData
	 */
	private static void changeData(String strData) {
		System.out.println("--> Hashcode inside changeData() before upper case: "+strData.hashCode());
		strData=strData.toUpperCase();
		System.out.println("--> Hashcode inside changeData() after upper case: "+strData.hashCode());
	}
}
