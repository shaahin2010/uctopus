package com.uctopus.exception;

public class UctopusApiException extends RuntimeException {

    public UctopusApiException() {
    }

    public UctopusApiException(String s) {
        super(s);
    }

    public UctopusApiException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UctopusApiException(Throwable throwable) {
        super(throwable);
    }

}
