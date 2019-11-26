package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName("com.moodanalyser.NewmoodAnalyser");
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
        }catch (ClassNotFoundException e){
            //e.printStackTrace();
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"class not found!!!");

        }

        return null;
    }

}
