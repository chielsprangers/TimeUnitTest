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
public class DayInWeekIT {
    
    public DayInWeekIT() {
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
        DayInWeek[] expResult = null;
        DayInWeek[] result = DayInWeek.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class DayInWeek.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        DayInWeek expResult = null;
        DayInWeek result = DayInWeek.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
