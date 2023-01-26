package com.MIS.MISTalks.Exceptions;

public class InvalidEmail extends Exception{
    public InvalidEmail() {

    }

    public InvalidEmail(String message) {
        super(message);
    }
}
