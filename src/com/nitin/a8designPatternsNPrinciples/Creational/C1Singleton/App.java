package com.nitin.a8designPatternsNPrinciples.Creational.C1Singleton;

public class App {

	/**
	 * Singleton Pattern -> restricts the instantiation of a class to one object
	 * This is useful when exactly one object is needed to coordinate actions across the system
	 * For Ex : We need exactly one object to coordinate actions across the system.
	 */
	public static void main(String[] args) {
		
		SingletonClass.INSTANCE.setCounter(10);	
		System.out.println(SingletonClass.INSTANCE.getCounter());
		
	}
}
