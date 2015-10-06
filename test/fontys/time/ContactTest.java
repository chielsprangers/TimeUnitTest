package fontys.time;

import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test voor Contact.
 * @author Kevin Berendsen
 */
public class ContactTest {
    private Contact contact;
    
    /**
     * Setup methode die zich elke keer uitvoerd voor elke test case.
     * @author Kevin Berendsen
     */
    @Before
    public void setUp() {
        contact = new Contact("Kevin");
    }

    /**
     * Maak een nieuw Contact-object. Bij het invoeren van null of niks,
     * moet er een IllegalArgumentException voorkomen
     * @author Kevin Berendsen
     */
    @Test
    public void testConstructor() {
        Contact c = new Contact("Kevin");
        assertNotNull("c mag niet null zijn.", c);
        assertEquals("Naam moet gelijk zijn", "Kevin", c.getName());
        
        // Testen van IllegalArgumentExceptions.
        try {
            c = new Contact(null);
            fail("Invoeren van null is niet toegestaan!");
        } catch (IllegalArgumentException ex) { }
        
        try {
            c = new Contact("");
            fail("Invoeren van niks is niet toegestaan!");
        } catch (IllegalArgumentException ex) { }
    }
    
    /**
     * Krijg de naam van de Contact-object.
     * @author Kevin Berendsen
     */
    @Test
    public void testGetName() {
        assertEquals("Namen moeten gelijk zijn.", "Kevin", contact.getName());
        assertFalse("Namen moeten ongelijk zijn.", contact.getName().equals("kevin"));
    }

    /**
     * Toevoegen van een nieuwe afspraak. Testen op verschillende mogelijkheden.
     * Daar hoort ook bij op Appointments die overlappen met elkaar.
     * @author Kevin Berendsen
     */
    @Test
    public void testAddAppointment() {
        //TODO Opdracht 9
        boolean setAppointment = false;
        Appointment aA = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 05, 19, 0, 0), 60));
        Appointment aB = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 05, 19, 1, 0), 60));
        Appointment aC = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 05, 19, 0, 30), 60));
        Appointment aD = new Appointment("Afspraak 4", new TimeSpan2(new Time(2015, 05, 18, 23, 30), 91));
        Appointment aE = new Appointment("Afspraak 5", new TimeSpan2(new Time(2015, 05, 18, 23, 30), 60));
        Appointment aF = new Appointment("Afspraak 6", new TimeSpan2(new Time(2015, 05, 19, 0, 0), 20));
        Appointment aG = new Appointment("Afspraak 7", new TimeSpan2(new Time(2015, 05, 18, 23, 0), 60));
        Appointment aH = new Appointment("Afspraak 8", new TimeSpan2(new Time(2015, 05, 19, 2, 0), 60));
        
        // Eerste afspraak
        setAppointment = contact.addAppointment(aA);
        assertEquals("Afspraak 1 moet gemaakt kunnen worden.", true, setAppointment);
        
        // Tweede afspraak
        setAppointment = contact.addAppointment(aB);
        assertEquals("Afspraak 2 moet ook gemaakt kunnen worden.", true, setAppointment);
        
        // Derde afspraak
        setAppointment = contact.addAppointment(aC);
        assertEquals("Afspraak 3 mag niet gemaakt kunnen worden.", false, setAppointment);
        
        // Vierde afspraak
        setAppointment = contact.addAppointment(aD);
        assertEquals("Afspraak 4 mag niet gemaakt kunnen worden.", false, setAppointment);
        
        // Vijfde afspraak
        setAppointment = contact.addAppointment(aE);
        assertEquals("Afspraak 5 mag niet gemaakt kunnen worden.", false, setAppointment);
        
        
        // Nogmaal eerste afspraak proberen toe te voegen.
        setAppointment = contact.addAppointment(aA);
        assertEquals("Nogmaals een afspraak toevoegen mag niet", false, setAppointment);
        
        // Valt nu binnen een bestaande afspraak
        setAppointment = contact.addAppointment(aF);
        assertEquals("Nieuwe afspraak valt binnen een bestaande afspraak. Mag niet.", false, setAppointment);
        
        // Afspraak komt voor afspraak 1
        setAppointment = contact.addAppointment(aG);
        assertEquals("Afspraak G komt voor 1", true, setAppointment);
        
        // Afspraak komt na afspraak 1
        setAppointment = contact.addAppointment(aH);
        assertEquals("Afspraak H komt na 1", true, setAppointment);
    }

    /**
     * Verwijderen van Appointments. Zelfs appointments die niet in de Contact
     * zijn agenda staat.
     * @author Kevin Berendsen
     */
    @Test
    public void testRemoveAppointment() {
        Appointment a = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 05, 19, 0, 0), 60));
        Appointment b = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 05, 19, 1, 0), 60));
        Appointment c = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 05, 19, 2, 0), 60));
        Appointment d = new Appointment("Afspraak 4", new TimeSpan2(new Time(2015, 05, 19, 3, 0), 60));
        contact.addAppointment(a);
        contact.addAppointment(b);
        contact.addAppointment(c);
        contact.addAppointment(d);
        
        contact.removeAppointment(c);
        contact.removeAppointment(a);
        Iterator<Appointment> apps = contact.appointments();
        assertNotNull("appointments() mag niet null zijn.", apps);
        while(apps.hasNext()) {
            Appointment tApp = apps.next();
            if(tApp.equals(c) || tApp.equals(a)) {
                fail("'Verwijderde' appointment bestaat nog.");
                return;
            }
        }
        
        try {
            contact.removeAppointment(null);
            fail("Parameter mag niet null zijn.");
        } catch (IllegalArgumentException ex) {}
    }

    /**
     * Verkrijgen van alle Appointments (agenda) in een Iterator. Het doorzoeken
     * van alle Appointment of ze gelezen kunnen worden
     * @author Kevin Berendsen
     */
    @Test
    public void testAppointments() {
        Appointment a = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 05, 19, 0, 0), 60));
        Appointment b = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 05, 19, 1, 0), 60));
        Appointment c = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 05, 19, 2, 0), 60));
        Appointment d = new Appointment("Afspraak 4", new TimeSpan2(new Time(2015, 05, 19, 3, 0), 60));
        contact.addAppointment(a);
        contact.addAppointment(b);
        contact.addAppointment(c);
        contact.addAppointment(d);
        

        Iterator<Appointment> apps = contact.appointments();
        assertNotNull("appointments() mag niet null zijn.", apps);
       
        while(apps.hasNext()) {
            if(!(apps.next() instanceof Appointment)) {
                fail("Moet wel een appointment in zitten.");
                return;
            }
        }
    }
    
}
