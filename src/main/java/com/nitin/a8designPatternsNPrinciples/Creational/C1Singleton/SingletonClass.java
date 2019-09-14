package com.nitin.a8designPatternsNPrinciples.Creational.C1Singleton;

public class  SingletonClass {

	//make the constructor private
	private SingletonClass(){}

	// make the instance variable static so that getInstance() is the only one available.
	private static SingletonClass object;

	//getter of the static instance variable
	public static SingletonClass getInstance(){
		if(object == null){
			object = new SingletonClass();
		}

		return object;
	}

	@Override
	public String toString() {
		return String.valueOf(System.currentTimeMillis());
	}

}
