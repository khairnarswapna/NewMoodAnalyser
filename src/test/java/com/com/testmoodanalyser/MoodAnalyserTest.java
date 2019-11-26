package com.com.testmoodanalyser;

import com.moodanalyser.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_whenSad_shouldReturnSad(){
        MoodAnalyser analyser = new MoodAnalyser();
        String mood = analyser.analyseMood("THis is is SAD Message");
        Assert.assertEquals("SAD",mood );

    }

}
