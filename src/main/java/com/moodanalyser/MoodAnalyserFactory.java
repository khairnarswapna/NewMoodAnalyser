package com.moodanalyser;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalysisClass.getConstructor(String.class);
            Object moodobj = moodConstructor.newInstance();
            return (MoodAnalyser) moodobj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "class not found!!!");

        }

        return null;
    }

    public static MoodAnalyser createMoodAnalyser2() throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalysisClass.getConstructor(Integer.class);
            Object moodobj = moodConstructor.newInstance();
            return (MoodAnalyser) moodobj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "No such method Found Error!!!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
