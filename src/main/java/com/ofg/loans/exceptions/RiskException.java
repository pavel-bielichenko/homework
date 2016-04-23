package com.ofg.loans.exceptions;

/**
 * Created by pavel on 20.04.16.
 */
public class RiskException extends Exception{
    private String message;

    public RiskException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
