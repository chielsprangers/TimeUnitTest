package fontys.time;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * IMPORTANT
 * @author Chiel Sprangers
 */
public class TimeSpan2IT {

    Time testTime1 = new Time(2015, 9, 27, 19, 20);
    Time testTime2 = new Time(2014, 8, 27, 19, 20);
    TimeSpan2 tsTest = new TimeSpan2(testTime2, testTime1.difference(testTime2));
    

    public TimeSpan2IT() {
        try {
            TimeSpan2 tsTestBeginTime = new TimeSpan2(testTime1, testTime2.difference(testTime1));
            
            
        } catch (Exception e) {

        }
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testGetBeginTime() {
        assertEquals("Moet gelijk zijn aan testTime2", testTime2, tsTest.getBeginTime());
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testGetEndTime() {        
        assertEquals("Moet gelijk zijn aan testTime1", 0, tsTest.getEndTime().difference(testTime1));
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testLength() {
        assertEquals("Moet gelijk zijn aan de return waarde", testTime1.difference(testTime2), tsTest.length());
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testSetBeginTime() {
        Time newTimeFaulty = new Time(2017, 12, 4, 19, 20);
        try {
            TimeSpan2 tsTestBeginTime = tsTest;
            tsTestBeginTime.setBeginTime(newTimeFaulty);
            Assert.fail("Should have thrown an exception");
        } catch (Exception e) {

        }
        Time newTimeCorrect = new Time(2014, 1, 1, 12, 01);
        TimeSpan2 tsTestBeginTime = tsTest;
        tsTestBeginTime.setBeginTime(newTimeCorrect);

    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testSetEndTime() {
        Time newTimeFaulty = new Time(2012, 12, 4, 19, 20);
        try {
            TimeSpan2 tsTestEndTime = tsTest;
            tsTestEndTime.setEndTime(newTimeFaulty);
            Assert.fail("Should have thrown an exception");
        } catch (Exception e) {

        }
        Time newTimeCorrect = new Time(2015, 1, 1, 12, 01);
        TimeSpan2 tsTestEndTime = tsTest;
        tsTestEndTime.setEndTime(newTimeCorrect);
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testMove() {
        Time testTime1Test = testTime1;
        Time testTime2Test = testTime2;
        testTime1Test.plus(60);
        testTime2Test.plus(60);
        TimeSpan2 tsTimeSpanTest = tsTest;
        tsTimeSpanTest.setBeginTime(testTime2Test);
        tsTimeSpanTest.setEndTime(testTime1Test);
        tsTest.move(60);
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTimeSpanTest, tsTest);
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testChangeLengthWith() {
        try {
            tsTest.changeLengthWith(0);
            Assert.fail("Should have thrown an exception");

        } catch (Exception e) {

        }
        Time testTime1Test = testTime1;
        testTime1Test.plus(60);
        TimeSpan2 tsTimeSpanTest = tsTest;
        tsTimeSpanTest.setEndTime(testTime1Test);
        tsTest.changeLengthWith(60);
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTimeSpanTest, tsTest);
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testIsPartOf() {
        Time testTime1Test = new Time(2015, 9, 27, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTestExtra = new TimeSpan2(testTime2Test, testTime1Test.difference(testTime2Test));
        assertEquals("Should be true", true, tsTest.isPartOf(tsTestExtra));
        
        Time testTime1Test2 = new Time(2014, 10, 29, 19, 20);
        Time testTime2Test2 = new Time(1900, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest2 = new TimeSpan2(testTime2Test2,testTime1Test2.difference(testTime2Test2));
        assertEquals("Moet false zijn", false, tsTest.isPartOf(tsTimeSpanTest2));
        
        Time testTime1Test3 = new Time(2015, 10, 29, 19, 20);
        Time testTime2Test3 = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest3 = new TimeSpan2(testTime2Test3,testTime1Test3.difference(testTime2Test3));
        assertEquals("Moet false zijn", false, tsTest.isPartOf(tsTimeSpanTest3));
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testUnionWith() {
        Time testTime1Test = new Time(2015, 8, 29, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest = new TimeSpan2(testTime2Test,testTime1Test.difference(testTime2Test));
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTimeSpanTest.getBeginTime(), tsTest.unionWith(tsTimeSpanTest).getBeginTime());
        
        testTime1Test = new Time(2015, 9, 13, 19, 20);
        testTime2Test = new Time(2015, 8, 27, 19, 20);
        tsTimeSpanTest = new TimeSpan2(testTime2Test,testTime1Test.difference(testTime2Test));
        assertEquals("Moet gelijk zijn ", tsTimeSpanTest.getBeginTime().getDay(), tsTest.unionWith(tsTimeSpanTest).getBeginTime().getDay());
        
        
        Time testTime1Test2 = new Time(2018, 8, 25, 19, 20);
        Time testTime2Test2 = new Time(2011, 8, 23, 19, 20);
        TimeSpan2 tsTimeSpanTest2 = new TimeSpan2(testTime2Test2, testTime1Test2.difference(testTime2Test2));
        
        assertEquals("Moet  zijn", tsTest.getEndTime().getYear(), tsTest.unionWith(tsTimeSpanTest2).getEndTime().getYear());
        
        Time testTime1Test3 = new Time(1901, 8, 29, 19, 20);
        Time testTime2Test3 = new Time(1900, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest3 = new TimeSpan2(testTime2Test3, testTime1Test3.difference(testTime2Test3));
        assertEquals("Moet  zijn", null, tsTest.unionWith(tsTimeSpanTest3));
        assertEquals("Moet null zijn", null, tsTimeSpanTest3.unionWith(tsTimeSpanTest2));
    }

    /**
     * @author Chiel Sprangers
     */
    @Test
    public void testIntersectionWith() {
        Time testTime1Test = new Time(2015, 8, 29, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest = new TimeSpan2(testTime2Test, testTime1Test.difference(testTime2Test));
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTimeSpanTest.getBeginTime().getDay(), tsTest.intersectionWith(tsTimeSpanTest).getBeginTime().getDay());
        
        
        testTime1Test = new Time(2019, 8, 29, 19, 20);
        testTime2Test = new Time(2012, 8, 27, 19, 20);
        tsTimeSpanTest = tsTest;
        tsTimeSpanTest.setBeginTime(testTime2Test);
        tsTimeSpanTest.setEndTime(testTime1Test);
        
        assertEquals("moet null zijn", null , tsTest.intersectionWith(tsTimeSpanTest));
    }

}