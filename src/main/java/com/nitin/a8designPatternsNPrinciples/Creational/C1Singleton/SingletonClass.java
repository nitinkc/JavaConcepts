package com.nitin.a8designPatternsNPrinciples.Creational.C1Singleton;

public class  SingletonClass {

	//make the constructor private, so that new keyword cannot be used
	private SingletonClass(){}

	// make the instance variable static so that getInstance() can call the only one available Singleton class object.
	private static SingletonClass object;

	// Eager initialization
	//private static SingletonClass object = new SingletonClass();

	//getter of the static instance variable
	public static SingletonClass getInstanceOfSingleton(){
		if(object == null){
			//Lazy Initialization, happens only when it is called
			object = new SingletonClass();
		}

		return object;
	}

	@Override
	public String toString() {
		return String.valueOf(System.currentTimeMillis());
	}

}
