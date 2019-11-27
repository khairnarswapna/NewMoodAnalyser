package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType{
        ENTERED_NULL, ENTERD_EMPTY , NO_SUCH_CLASS , NO_SUCH_METHOD ,METHOD_INVOCATION_ISSUE,NO_SUCH_FIELD,NO_ACCESS,OBJECT_CREATION_ISSUE
    }
    public ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
    public MoodAnalysisException(String enter_proper_class_name) {
        super(enter_proper_class_name);
    }
    public MoodAnalysisException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type=type;
    }
}

