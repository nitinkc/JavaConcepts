package com.nitin.a8designPatternsNPrinciples.Behavioral.B1Strategy;

public class Manager implements Strategy{

	// Since Add and Multiply has B1Strategy implemented,
	private Strategy strategy;// this is Composition
	
	public void setStrategy(Strategy strategy){
		this.strategy = strategy;
	}

	@Override
	public void operation(int num1, int num2) {
		this.strategy.operation(num1, num2);
	}
}
