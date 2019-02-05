package com.sg.unittestingexercises;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
public class AlarmClockTest {
    AlarmClock instance = new AlarmClock();
    public AlarmClockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    @Test
    public void MondayNoVacation() {
        assertEquals("7:00", instance.alarmClock(1, false));
    }
    
    @Test
    public void FridayNoVacation() {
        assertEquals("7:00", instance.alarmClock(5, false));
    }
    
    @Test
    public void SundayNoVacation() {
        assertEquals("10:00", instance.alarmClock(0, false));
    }
    
    @Test
    public void SaturdayNoVacation() {
        assertEquals("10:00", instance.alarmClock(6, false));
    }
    
        @Test
    public void MondayVacation() {
        assertEquals("10:00", instance.alarmClock(1, true));
    }
    
    @Test
    public void FridayVacation() {
        assertEquals("10:00", instance.alarmClock(5, true));
    }
    
    @Test
    public void SundayVacation() {
        assertEquals("Off", instance.alarmClock(0, true));
    }
    
    @Test
    public void SaturdayVacation() {
        assertEquals("Off", instance.alarmClock(6, true));
    }
    
}
