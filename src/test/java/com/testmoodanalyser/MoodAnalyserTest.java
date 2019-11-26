package com.testmoodanalyser;

import com.moodanalyser.MoodAnalyser;
import com.moodanalyser.MoodAnalyserFactory;
import com.moodanalyser.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;
import sun.awt.X11.XConstants;

import static org.junit.Assert.*;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws MoodAnalysisException {
        MoodAnalyser analyser = new MoodAnalyser("THis is is SAD Message");
        String mood = analyser.analyseMood();
        assertEquals("SAD",mood );

    }
    @Test
    public void  givenMessage_whenthemoodnull_shouldReturnHappy() throws MoodAnalysisException
    {
        MoodAnalyser analyser = new MoodAnalyser(null);
        try {
            String mood = analyser.analyseMood(null);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("please Enter valid Mood",e.getMessage());
        }
    }
    @Test
    public void giveNullMoodShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }
     @Test
    public void giveEmptyMoodShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(" ");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERD_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObjet() throws MoodAnalysisException
    {
        MoodAnalyser moodAnalyser1 = null;
        try {
            moodAnalyser1 = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyser moodAnalyser= new MoodAnalyser();
            boolean result= moodAnalyser1.equals(moodAnalyser);
            Assert.assertTrue(result);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*@Test
    public void givenMoodAnalyserClass_() throws MoodAnalysisException
    {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyser moodAnalyser1= new MoodAnalyser();
            boolean result= moodAnalyser.equals(moodAnalyser,moodAnalyser1);
            Assert.assertFalse(result);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/




}
