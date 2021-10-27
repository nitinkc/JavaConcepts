package com.nitin.a24regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexSmall {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abaaaaabaaabaabbbababababbaababbababbabaabbaba");
		while(m.find()){
			System.out.print(m.start()+ " ");
		}

	}

}
