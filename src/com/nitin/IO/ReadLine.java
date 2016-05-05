package com.nitin.IO;
import java.io.*;
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
