package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalysisClass.getConstructor(String.class);
            Object moodobj = moodConstructor.newInstance(message);
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

    /*invoke method  */
    public static Object invokeMethod(Object moodAnalyserObject,String methodName) throws MoodAnalysisException {

        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Defined proper method");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE,"Method innocation issue");
        }

    }

    /*setField Method*/
    public static void setField(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);

        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "define proper field name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "may be issue with data Entered ");
        }

    }

    /*public static Constructor<?> getConstructor(Object... param) {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.MoodAnalyser");
            moodAnalysisClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "class not found!!!");
        }catch (NoSuchMethodException e){

        }
    }*/

    /*public static Object createMoodAnalyser{

    }*/s

}
