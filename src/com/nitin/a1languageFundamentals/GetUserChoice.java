package com.nitin.a1languageFundamentals;

import java.util.Scanner;

public class GetUserChoice {
	
	/**
	 * <insert method description here>
	 *
	 * @param:
	 * 
	 */
	public static void main(String[] args) {
		int choice = 0;
		Scanner scannerObject = new Scanner(System.in);

		while (true) {

			System.out.println("Menu");
			System.out.println("1.  Choice 1");
			System.out.println("2.  Choice 2");
			System.out.println("3.  Choice 3");
			System.out.println("4.  Quit");

			System.out.print("Please enter your next menu choice: ");
			choice = scannerObject.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Choice was 1");
					break;
				case 2:
					System.out.println("Choice was 2");
					break;
				case 3:
					System.out.println("Choice was 3");
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Invalid choice = " + choice);
			}
		}
		//System.out.println("Out of loop");
	}
}
