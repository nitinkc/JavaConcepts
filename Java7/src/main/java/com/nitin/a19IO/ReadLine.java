package com.nitin.a19IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReadLine {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			
		    System.out.println("Enter something");
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		    String sample = br.readLine();
		    System.out.println(sample);
	}

}
