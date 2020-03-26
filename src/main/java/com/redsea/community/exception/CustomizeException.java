package com.redsea.community.exception;

public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public String getMessgae() {
        return message;
    }

}

