package com.nitin.a10collections;

public class EqualsTest {
	public static void main(String[] arg) {

		Integer i = new Integer(3);
		Integer j = new Integer(3);

		if (i == j) //2 different objects
			System.out.println("true");
		else
			System.out.println("false");
	}
}