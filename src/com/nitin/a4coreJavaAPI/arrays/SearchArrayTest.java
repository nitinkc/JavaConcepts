package com.nitin.a4coreJavaAPI.arrays;
import java.util.*;
public class SearchArrayTest {
	public static void main(String[] args) {

		String[] friends = {"Prashant","Ritesh","Leena","Vikram","Shiv Mohan","Dhan Singh","Abhishek","Shailesh","Neeraj"};
		System.out.println(friends);//See the weird output
		for (String i : friends)
		System.out.print(i + " ");
		
		//BINARY SEARCH --> BINARY SEARCH WORKS ON SORTED ARRAYS,HERE IS BasicConnection TEST OF THAT
		System.out.print("\nPrashant = "); //to give a line change 
		System.out.println(Arrays.binarySearch(friends, "Prashant"));
		System.out.println("Abhishek = " + Arrays.binarySearch(friends, "Abhishek"));
		
		
		//SORTING ARRAY
		Arrays.sort(friends);
		System.out.print("\n"); //to give a line change
		for (String i : friends)
		System.out.print(i + " ");
		
		//BINARY SEARCH --> BINARY SEARCH WORKS ON SORTED ARRAYS
		System.out.print("\nPrashant = "); //to give a line change 
		System.out.println(Arrays.binarySearch(friends, "Prashant"));
		System.out.println("Abhishek = " + Arrays.binarySearch(friends, "Abhishek"));
		
		//REVERSE SORT
		// WHY IS IT NOT WORKING
		RevSortThruComparator rs = new RevSortThruComparator();
		Arrays.sort(friends,rs);
		for (String i : friends)
			System.out.print(i + " ");
		System.out.println("\nVikram in rev Sort = " + Arrays.binarySearch(friends,"Vikram", rs));
		
		List friendList = Arrays.asList(friends);
		System.out.println("List of Friends " + friendList);
		System.out.println(friendList.get(5));
		System.out.println(friendList.set(7,"TEST"));
		System.out.println("List of Friends " + friendList);
		//friendList.add(8, "TEST2");
		//friendList.add("TEST3");
		
		//ARRAY IS UPDATED AS WELL
		for (String i : friends)
			System.out.print(i + " ");
		
		}
}
	
	class RevSortThruComparator implements Comparator<String>{
		public int compare(String a,String b){
			return b.compareTo(a);
		}
	}

