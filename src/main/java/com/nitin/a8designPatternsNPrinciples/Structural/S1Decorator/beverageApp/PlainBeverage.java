package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.beverageApp;

public class PlainBeverage implements Beverage {

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "";
	}
}
