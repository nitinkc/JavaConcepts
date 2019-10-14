package com.nitin.a8designPatternsNPrinciples.Creational.C4DataAccessObjectPattern;

public class App {

	public static void main(String[] args) {
		Database database = new Database();
		
		database.insert(new Person("John", 27));
		database.insert(new Person("Adam", 47));
		database.insert(new Person("Joe", 37));
		
		for(Person person : database.getPeople()){
			System.out.println(person);
		}
	}
}