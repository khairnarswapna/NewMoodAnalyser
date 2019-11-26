package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType{
        ENTERED_NULL, ENTERD_EMPTY , NO_SUCH_FIELD , NO_SUCH_METHOD,
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

