package com.nitin.a8designPatternsNPrinciples.Behavioral.B1Strategy;

public class Add implements Strategy{

	@Override
	public void operation(int num1, int num2) {
		System.out.println(num1+num2);
	}
}
