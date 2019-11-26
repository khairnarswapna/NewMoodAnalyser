package com.moodanalyser;

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
            else
                return "HAPPY";

        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "please enter proper meassage");
        }
    }

    public boolean equals(Object another) {
        if (this.message.equals(((MoodAnalyser) another).message)) {
            System.out.println(this.message.hashCode());
             System.out.println(((MoodAnalyser) another).message.hashCode());
            return true;
        }
        return false;
    }


}