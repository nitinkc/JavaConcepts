package com.nitin.a8designPatternsNPrinciples.Behavioral.B7VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class App {

	/**
	 *  Visitor Pattern -> way of separating an algorithm from an object structure on which it operates
	 *
	 *  		A practical Result if this separation is the ability to add
	 *  	new ooperations to existing Object Structure without modifying these structures
	 *
	 *  - we can sole the open-closed principle into a unique class
	 *  for example WebShop application
	 */

	public static void main(String[] args) {
		
		List<ShoppingItem> items = new ArrayList<>();
		items.add(new Table("table",22));
		items.add(new Table("table",3));
		items.add(new Table("table",2));
		items.add(new Chair("chair",45));
		
		double sum = 0;
		ShoppingCartVisitor shoppingCart = new ShoppingCart();
		
		for(ShoppingItem shoppingItem : items)
			sum = sum + shoppingItem.accept(shoppingCart);
		
		System.out.println(sum);
	}
}
