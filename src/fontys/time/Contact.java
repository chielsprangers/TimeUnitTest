package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//  Specificeren is gedaan door de class author.
//  Implementatie is gedaan door methods author.

/**
 * Contact class. 
 * @author Kevin Berendsen
 */
public class Contact {
    /**
     * Naam van de contact
     */
    private String name;
    
    /**
     * Een lijst met Appointment die dient als agenda.
     */
    private List<Appointment> appointments;
    
    
    
    /**
     * Maak een nieuwe contact aan met de naam als constructor.
     * Constructor moet ook een nieuw lijst met Appointment aanmaken.
     * @param name van de contact. Mag niet null of leeg zijn, 
     * anders IllegalArgumentException
     * @author Danny ter Haar
     */
    public Contact(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Cannot be empty");
        }
        this.name = name;
        appointments = new ArrayList<Appointment>();
    }
    
    /**
     * Verkrijg de naam de Contact-object.
     * @return naam van de contact.
     * @author Danny ter Haar
     */
    public String getName() {
        //TODO Opdracht 10
        return name;
    }
    
    /**
     * Toevoegen van een nieuwe Appointment. De nieuwe appointment mag niet
     * overlappen met een andere afspraak. Begin moet ook eerlijk zijn dan
     * de eind tijd van de appointment.
     * @param a appointment die moet worden toegevoegd aan de lijst van
     * appointments.
     * @return true als het toevoegen van een nieuwe Appointment is gelukt en 
     * false als het niet lukte.
     * @author Danny ter Haar
     */
    boolean addAppointment(Appointment a) {
        Iterator<Appointment> as = this.appointments();
        while(as.hasNext()) {
            Appointment t = as.next();
            if(t.equals(a))
                return false;
            
            ITimeSpan time = t.getTimeSpan();
            ITimeSpan duration = a.getTimeSpan();
            
            // Tijd valt eruit met andere tijd erin.
            if(duration.getBeginTime().difference(time.getBeginTime()) <= 0
                && duration.getEndTime().difference(time.getEndTime()) >= 0)
                return false;
            
            // Eind tijd valt erin
            if(duration.getEndTime().difference(time.getBeginTime()) > 0
                && duration.getEndTime().difference(time.getEndTime()) < 0)
                return false;
            
            // Begin tijd valt erin.
            if(duration.getBeginTime().difference(time.getBeginTime()) >= 0
                && duration.getBeginTime().difference(time.getEndTime()) < 0)
                return false;
            
        }
        
        appointments.add(a);
        return true;
    }
    
    /**
     * Het verwijderen van een appointment. Als de appointment bestaat, moet
     * die verwijderd worden uit de lijst appointments en anders gebeurd er
     * helemaal niks.
     * @param a appointment die verwijderd moet worden.
     * @author Danny ter Haar
     */
    void removeAppointment(Appointment a) {
        if(a == null)
            throw new IllegalArgumentException("a mag niet null zijn.");
        appointments.remove(a);
    }
    
    /**
     * Verkrijg alle Appointments doormiddel van een iterator
     * zodat ze er alleen door heen kunnen kijken.
     * @return Iterator met alle appointments.
     * @author Danny ter Haar
     */
    public Iterator<Appointment> appointments() {
        //TODO Opdracht 10
        return appointments.iterator();
    }
}