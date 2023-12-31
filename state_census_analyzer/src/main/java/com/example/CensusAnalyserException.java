package com.example;

public class CensusAnalyserException extends Exception {
    public enum CensusExceptionType {
        NO_SUCH_FILE, SOME_IO_EXCEPTION, NO_SUCH_CLASS
    }

    public CensusExceptionType type;
    private String message;

    public CensusAnalyserException() {
    }

    public CensusAnalyserException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
