package com.practice.firstassignment;

import java.util.Arrays;

/**
 * @author Shrikant_Bhadgaonkar
 * 2.Basic Datatypes, variable types, Modifier types, final keyword, Constructors
 */

public class StringsAndArrays {

	public static void main(String[] args) {
//		------------------Strings--------------------
//		String declaration and initialization
		String testString1="Shrikant";
		String testString2=new String("Shrikant");
		String testString3=testString1;
		String testString4=new String("Shrikant").intern();
		System.out.println("Testing equality between 1 and 2 using == "+(testString1==testString2));
		System.out.println("Testing equality between 1 and 2 using equals "+(testString1.equals(testString2)));
		System.out.println("Testing equality between 1 and 3 using =="+(testString1==testString3));
		System.out.println("Testing equality between 1 and 4 using =="+(testString1==testString4));
//		concatenation
		String concatString1=testString1.concat(testString4);
		String concatString2=testString1+testString2;
//		Changing to lowercase
		String caseString1=testString1.toLowerCase();
//		Changing to uppercase
		String caseString2=testString1.toUpperCase();
		System.out.println("length of String: "+testString1.length());
		System.out.println("Concatenation: "+concatString1+", "+concatString2);
		System.out.println("Case operation: "+caseString1+", "+caseString2);
		StringBuilder  newTestString= new StringBuilder("Hello! ");
		newTestString.append("ISS");
		System.out.println(newTestString);
//		----------------Arrays---------------------
//		initialization
		int[] testIntArray;
		testIntArray= new int[]{1,2,3,4,5};
		String[] testStringArray1= {"Hi","How","Are","You"};
		String[] testStringArray2= new String[5];
//		length
		System.out.println("Length of integer arrray: "+testIntArray.length);
//		iteration
		for(String i:testStringArray2)System.out.print(i+" ");
		System.out.println();
		for(int i=0;i<testIntArray.length;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
//		accessing elements
		System.out.println("First element in string array: "+testStringArray1[0]);
//		Sorting
		Arrays.sort(testStringArray1);
		System.out.println("Sorted string array: ");
		for(String i:testStringArray1)System.out.print(i+" ");
		System.out.println();
//		Searching
		System.out.println("Searching number 6 in integer array: ");
		System.out.println("Found at? "+Arrays.binarySearch(testIntArray, 6));
		
	}

}
