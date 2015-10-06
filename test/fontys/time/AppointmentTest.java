/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Marco, Chiel
 */
public class AppointmentTest {
    Appointment ap;
    Time time1;
    Time time2;
    TimeSpan ts;
    public AppointmentTest() {
        time1 = new Time(2014,12,4,12,00);
        time2 = new Time(2015,12,4,12,00);
        ts = new TimeSpan(time1, time2);
        ap = new Appointment("Yolo", ts);
        
    }
    
    @Test
    public void testConstructor() {
        try {
            Appointment a = new Appointment(null, ts);
            fail("Subject mag niet null zijn.");
        } catch (IllegalArgumentException ex) {}
        
        try {
            Appointment a = new Appointment("Test", null);
            fail("Timespan mag niet null zijn.");
        } catch (IllegalArgumentException ex) {}
    }

    /**
     * Test of getSubject method, of class Appointment.
     * @author Marco, Chiel
     */
    @Test
    public void testGetSubject() {
        assertEquals("Should be yolo", "Yolo", ap.getSubject());
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     * @author Marco, Chiel
     */
    @Test
    public void testGetTimeSpan() {
        assertEquals("Should be equal to ts", ts, ap.getTimeSpan());
    }

    /**
     * Test of invitees method, of class Appointment.
     * @author Marco, Chiel
     */
    @Test
    public void testInvitees() {
        Contact c = new Contact("Danny ter Haar");
        Contact c2 = new Contact("Kevin Berendsen");
        ap.addContact(c);
        ap.addContact(c2);
        int size = 0;
        Iterator<Contact> it = ap.invitees();
        while(it.hasNext()) {
            it.next();
            size++;
        }
        assertEquals("Should be 2", 2, size);
    }

    /**
     * Test of AddContact method, of class Appointment.
     * @author Marco, Chiel
     */
    @Test
    public void testAddContact() {
        Contact c = new Contact("Danny ter Haar");
        Contact c2 = new Contact("Kevin Berendsen");
        ap.addContact(c);
        ap.addContact(c2);
        
        Appointment a = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 05, 19, 0, 0), 60));
        assertFalse("Mag niet goed gekeurd worden.", a.addContact(c));
        Appointment b = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 05, 19, 0, 30), 60));
        assertFalse("Mag niet goed gekeurd worden.", a.addContact(c));
    }

    /**
     * Test of removeContact method, of class Appointment.
     * @author Marco, Chiel
     */
    @Test
    public void testRemoveContact() {
        Contact c = new Contact("Danny ter Haar");
        Contact c2 = new Contact("Kevin Berendsen");
        ap.addContact(c);
        ap.removeContact(c);
        ap.removeContact(c2);
    }
    
}
