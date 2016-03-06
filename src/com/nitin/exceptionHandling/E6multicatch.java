package com.nitin.exceptionHandling;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Created by Nitin C on 3/5/2016.
 * multi-catch block
 * In Java 7, they introduce the the ability to catch multiple exceptions in the same catch block.
 * catch (FileNotFoundException | IOException e) redundant exceptions gives the error.
 * Error MULTI-CATCH Must be disjoint
 */
public class E6multicatch {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("text.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) { //No duplicacy of code
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
