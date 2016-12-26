package com.nitin.arrays;

import java.util.*;


public class ArrayAsList {
	public static void main(String nitin[]){
		String[] a = {"one","two","three","four"};

		//String Array doesnot behave like regular arrays. contains methid wont work
		//a.contains("one");

		System.out.println(Arrays.asList(a).contains("two"));//true
		System.out.println(Arrays.asList(a).contains("nitin"));//false

		// Arrays Class has method asList returning is
		System.out.println(Arrays.asList(a));
		List<String> aList = Arrays.asList(a);
		System.out.println(aList);
	}

}
