package com.com.testmoodanalyser;

import com.moodanalyser.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;
import sun.awt.X11.XConstants;

import static org.junit.Assert.*;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_whenSad_shouldReturnSad(){
        MoodAnalyser analyser = new MoodAnalyser("THis is is SAD Message");
        String mood = analyser.analyseMood();
        assertEquals("SAD",mood );

    }
    @Test
    public void givenMessage_whenHAPPY_shouldReturnHappy() {
        MoodAnalyser analyser = new MoodAnalyser("THis is is HAPPY Message");
        String mood = analyser.analyseMood();
        assertEquals("HAPPY",mood);
    }
}
