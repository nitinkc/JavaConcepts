package com.nitin.collections.set;
import java.util.*;
public class FindDuplicates {
	public static void main(String[] args) {
		
		String[] test = {"i","came","i","saw","i","left"};
		Set<String> s = new HashSet<String>();
		for (String g : test)
			if(!s.add(g))
				System.out.println("Duplicate detected " + g);
		System.out.println(s.size() + "\ndistinct words: " + s);
		
		Set<String> uniques = new HashSet<String>();
		Set<String> dups = new HashSet<String>();
		
		for(String g:test)
			if(!uniques.add(g)) //uniques.add will return true
				dups.add(g);
		
		uniques.removeAll(dups);
		
		System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
				
		}
	

	}
