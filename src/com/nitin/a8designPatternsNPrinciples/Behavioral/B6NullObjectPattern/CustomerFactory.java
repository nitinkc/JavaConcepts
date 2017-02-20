package com.nitin.a8designPatternsNPrinciples.Behavioral.B6NullObjectPattern;

public class CustomerFactory {

	private Database database;
	
	public CustomerFactory(){
		this.database = new Database();
	}
	
	public AbstractCustomer getCustomer(String name){
		
		if( checkName(name) ){
			return new RealCustomer(name);
		}
		
		return new NullCustomer();
	}

	private boolean checkName(String name) {
		if( database.existCustomer(name) ){
			return true;
		}
	
		return false;
	}	
}
