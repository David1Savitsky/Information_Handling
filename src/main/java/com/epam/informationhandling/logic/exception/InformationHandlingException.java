package com.epam.informationhandling.logic.exception;

public class InformationHandlingException extends Exception {

    public InformationHandlingException() {
    }

    public InformationHandlingException(String message) {
        super(message);
    }

    public InformationHandlingException(Throwable cause) {
        super(cause);
    }

    public InformationHandlingException(String message, Throwable cause) {
        super(message, cause);
    }
}
