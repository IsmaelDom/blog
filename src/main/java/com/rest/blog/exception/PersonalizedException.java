package com.rest.blog.exception;

public class PersonalizedException extends Exception {
    private int codeError;

    public PersonalizedException(String errorMessage, int codeError) {
        super(errorMessage);
        this.codeError = codeError;
    }

    public int getCodeError() {
        return codeError;
    }

    public void setCodeError(int codeError) {
        this.codeError = codeError;
    }

    public int getCodigoError() {

        return 0;
    }
}
