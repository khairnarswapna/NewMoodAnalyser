package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {


    /*invoke method  */
    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException {

        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Defined proper method");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, "Method innocation issue");
        }

    }

    /*setField Method*/
    public static void setField(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);

        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "define proper field name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "may be issue with data Entered ");
        }

    }

    public static Constructor<?> getConstructor( Class<?>... param)throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.MoodAnalyser");
            return moodAnalysisClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException( MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "class not found!!!");
        }catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Defined proper method");
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor,Object... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException( MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE,"object creation issue");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException( MoodAnalysisException.ExceptionType.NO_ACCESS,"illegal accsessof class!!!");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException( MoodAnalysisException.ExceptionType.NO_ACCESS,"object creation issue");
        }

    }


}
