package com.nitin.a7exceptionHandling;

/**
 * Created by Nitin Chaurasia on 3/6/16 at 1:15 AM.
 *
 * Java Commits to closing automatically any resource opened in the try block.
 * For this reason the resource must be closeable!!
 *
 * Autocloseable interface has only one method to implement close()!!
 *
 * Checked Exception thus have to give a catch block
 */
public class E8AutoCloseable {
    public static void main(String[] args) {
        try(StuckInACage test = new StuckInACage()){//Throws checked exceptions
            System.out.println("Fear Holds you its prisoner!!");
        }catch (Exception e){// Swollowing the Exception

        }
    }

}

class StuckInACage implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}
