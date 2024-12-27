package com.scm.helpers;

public class ResourceNotFoundEXception extends RuntimeException{

    public ResourceNotFoundEXception(String message) {
        super(message);
    }
    public ResourceNotFoundEXception() {
        super("Resource not found");
    }

}
