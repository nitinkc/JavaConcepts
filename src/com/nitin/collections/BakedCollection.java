package com.nitin.collections;
import java.util.*;
public class BakedCollection {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant");
		map.put("d", "dog");
		map.put("h", "horse");
		
		SortedMap<String, String> submap;
		submap = map.subMap("b", "g"); // #1 create a backed collection from b to g
		System.out.println(map + " " + submap); // #2 show contents
		map.put("b", "bat"); // #3 add to original
		submap.put("f", "fish"); // #4 add to copy
		map.put("r", "raccoon"); // #5 add to original - out of range
		// submap.put("p", "pig"); // #6 add to copy - out of range exception will be thrown
		System.out.println(map + " " + submap); // #7 show final contents

	}

}
