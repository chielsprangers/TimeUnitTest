/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author chielsprangers
 */
public class TimeTest {
    Time instance;
    
    @Before
    public void setUp() {
        instance = new Time(2015, 9, 22, 12, 1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTime(){
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, 22, 12, 61);
        fail("Minuten error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, 22, 25, 1);
        fail("Uren error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, 33, 12, 1);
        fail("Dagen error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 13, 22, 12, 1);
        fail("Maanden error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, 22, 12, -1);
        fail("Minuten error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, 22, -1, 1);
        fail("Uren error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, 9, -1, 12, 1);
        fail("Dagen error");
        } catch (Exception e) {
        }
        
        try {
            System.out.println("Time");
        Time testInstance = new Time(2015, -1, 22, 12, 1);
        fail("Maanden error");
        } catch (Exception e) {
        }
        
        
    }
    
    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        Time testInstance = new Time(2015,9,21,12,1);
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,22,12,1);
        expResult = DayInWeek.TUE;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,23,12,1);
        expResult = DayInWeek.WED;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,24,12,1);
        expResult = DayInWeek.THU;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,25,12,1);
        expResult = DayInWeek.FRI;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,26,12,1);
        expResult = DayInWeek.SAT;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
        
        testInstance = new Time(2015,9,27,12,1);
        expResult = DayInWeek.SUN;
        result = testInstance.getDayInWeek();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 2015;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        int expResult = 9;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        int expResult = 22;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 12;
        int result = instance.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        int expResult = 1;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 5;
        int expResult = (instance.getMinutes() + minutes);
        instance = (Time) instance.plus(minutes);
        int result = instance.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Time t = new Time(2015, 9, 22, 12, 1);
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        
        t = new Time(2015, 9, 22, 12, 2);
        expResult = 1;
        result = instance.compareTo(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        Time time = new Time(2015, 9, 22, 12, 1);
        int expResult = 0;
        int result = instance.difference(time);
        assertEquals(expResult, result);
        
        time = new Time(2015, 9, 22, 12, 2);
        expResult = -1;
        result = instance.difference(time);
        assertEquals(expResult, result);
    }
    
}
