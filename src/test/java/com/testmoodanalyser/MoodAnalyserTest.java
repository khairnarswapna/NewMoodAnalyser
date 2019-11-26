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
            Assert.assertEquals("please enter proper meassage",e.getMessage());
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
    public void givenMoodAnalyserClass_whenProper_ShouldReturnObject()
   {
       try {
           MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("i am in HAPPY mood ");
           String mood = moodAnalyser.analyseMood();
           Assert.assertEquals("HAPPY",mood);
       }
       catch (MoodAnalysisException e){
           e.printStackTrace();
       }
   }
    @Test
    public void givenMoodAnalyserClass_whenClassIsNameImproper_shouldThrow_MoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in HAPPY mood");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }


    @Test
    public void givenMoodAnalyserClass_whenMethodNameIsImproper_shouldThrow_MoodAnalysisException(){
        MoodAnalyser moodAnalyser=null;
        try {
             moodAnalyser = MoodAnalyserFactory.createMoodAnalyser2();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("No such method Found Error!!!",e.getMessage());
        }
    }









}
