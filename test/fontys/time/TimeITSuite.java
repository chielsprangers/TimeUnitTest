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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author chielsprangers
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({fontys.time.TimeIT.class, fontys.time.ITimeSpanIT.class, fontys.time.DayInWeekIT.class, fontys.time.TimeSpanIT.class, fontys.time.ITimeIT.class})
public class TimeITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
