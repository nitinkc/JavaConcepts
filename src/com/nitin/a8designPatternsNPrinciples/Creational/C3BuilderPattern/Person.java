package com.nitin.a8designPatternsNPrinciples.Creational.C3BuilderPattern;

public class Person {

	private final String name;
	private final String email;
	private final String address;
	private final int age;
	private final String nameOfMother;
	
	public Person(Builder builder){
		this.name = builder.name;
		this.email = builder.email;
		this.address = builder.address;
		this.age = builder.age;
		this.nameOfMother = builder.nameOfMother;
	}
	
	public static class Builder {
		// finals for compulsory
		private final String name;
		private final String email;
		private String address;
		private int age;
		private String nameOfMother;
		
		public Builder(String name, String email){
			this.name = name;
			this.email = email;
		}

		// Setters for non compulsory parameters
		public Builder setAddress(String address){
			this.address = address;
			return this;
		}
		
		public Builder setNameOfMother(String nameOfMother){
			this.nameOfMother = nameOfMother;
			return this;
		}
		
		public Builder setAge(int age){
			this.age = age;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
	
	@Override
	public String toString() {
		return this.name+"-"+this.address+"-"+this.email+"-"+this.age;
	}
}
