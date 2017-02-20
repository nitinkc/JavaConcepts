package com.nitin.a8designPatternsNPrinciples.Behavioral.B7VisitorPattern;

public interface ShoppingItem {
	public double accept(ShoppingCartVisitor visitor);
}
