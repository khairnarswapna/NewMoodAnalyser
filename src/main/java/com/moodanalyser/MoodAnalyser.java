package com.moodanalyser;

import java.lang.reflect.Constructor;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }
    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0) {

                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERD_EMPTY, "please enter proper meassage");

            }
            if (message.contains("SAD"))
                return "SAD";
            else if(message.contains("HAPPY"))
                return "HAPPY";
           else
               return " ";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "please enter proper meassage");
        }
    }
    public boolean equals(Object obj) {
       if(obj instanceof MoodAnalyser)
           return true;
        return false;
   }


    
}