/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chielsprangers
 */
public class DayInWeekTest {
    
    public DayInWeekTest() {
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

    /**
     * Test of values method, of class DayInWeek.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        DayInWeek[] expResult = {DayInWeek.SUN,DayInWeek.MON, DayInWeek.TUE, DayInWeek.WED, DayInWeek.THU, DayInWeek.FRI, DayInWeek.SAT};
        DayInWeek[] result = DayInWeek.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class DayInWeek.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "MON";
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = DayInWeek.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
