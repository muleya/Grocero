package com.grocero.exceptions;

public class CustomerDoesNotExistException extends Exception {

    public CustomerDoesNotExistException() {
        super("Customer does not exist");
    }
}
