package com.nitin.a7exceptionHandling.customizedExceptions;

/**
 * Created by Nitin C on 11/27/2015.
 *
 * User defined exceptions should ALWAYS be checked
 * But you can extend any exception class
 * 1. Exception for custon checked exception
 * 2. RuntimeException for unchecked
 *
 */
public class CannotSwimException extends Exception {
    public CannotSwimException() {
        super();
    }

    public CannotSwimException(String message) {
        super(message);
    }

    public CannotSwimException(Exception e) {
        super(e);
    }
}
