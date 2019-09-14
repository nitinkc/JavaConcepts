package com.nitin.a4coreJavaAPI.arrays;
import java.util.*;
public class SearchArrayTest {
	public static void main(String[] args) {
		String[] list = {"zz","ab", "cd", "ef", "gh", "ij", "kl", "mn", "op", "qr"};

		//BINARY SEARCH --> BINARY SEARCH WORKS ON SORTED ARRAYS,HERE IS BasicConnection TEST OF THAT
		System.out.println("Position of zz in Array = " + Arrays.binarySearch(list, "zz"));
		System.out.println("Position of ab in Array = " + Arrays.binarySearch(list, "ab"));

		//SORTING ARRAY
		Arrays.sort(list);

		//BINARY SEARCH --> BINARY SEARCH WORKS ON SORTED ARRAYS
		System.out.println("zz = " + Arrays.binarySearch(list, "zz"));
		System.out.println("ab = " + Arrays.binarySearch(list, "ab"));

		//REVERSE SORT
		Arrays.sort(list, new RevSortThruComparator());
/*		for (String i : friends)
			System.out.print(i + " ");*/

		System.out.println("\nkl in rev Sort = " + Arrays.binarySearch(list, "kl", new RevSortThruComparator()));
	}
}
	
	class RevSortThruComparator implements Comparator<String>{
		public int compare(String a,String b){
			return b.compareTo(a);
		}
	}

