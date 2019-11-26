package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType{
        ENTERED_NULL,
    }
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }

    public MoodAnalysisException(String message) {
        super(message);
    }


    public MoodAnalysisException(ExceptionType type, Throwable cause)
    {
        super(cause);
        this.type=type;
    }
}

