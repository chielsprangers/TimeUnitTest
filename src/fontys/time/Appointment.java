package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * IMPORTANT
 * 
 * Danny heeft de specificatie gedaan. Kevin heeft het geïmplementeerd.
 * @author Danny Ter Haar
 */


public class Appointment {
    /**
     * Het onderwerp van de Appointment, mag een lege string zijn.
     */
    private String subject;
    
    /**
     * De duur van de appointment
     */
    private ITimeSpan duration; 
    
    /**
     * Het aantal uitgenodigde mensen
     * Dit mag 0 of meer zijn.
     */
    private List<Contact> invitedPeople;
    
    
    /**
     * 
     * @param subject Het onderwerp van de Appointment, mag een lege string zijn ("")
     * @param timeSpan De duur van de Afspraak
     * @author Kevin Berendsen
     */
    public Appointment(String subject, ITimeSpan timeSpan){
        if(subject == null)
            throw new IllegalArgumentException("subject mag niet null zijn.");
        
        if(timeSpan == null)
            throw new IllegalArgumentException("timeSpan mag niet null zijn.");
        
        this.invitedPeople = new ArrayList<>();
        this.duration = timeSpan;
        this.subject = subject;
    }
    
    /**
     * 
     * @return returned het onderwerp van de Appointment
     * @author Kevin Berendsen
     */
    public String getSubject(){
        return subject;
    }
    
    /**
     * 
     * @return returned de tijd van de Appointment
     * @author Kevin Berendsen
     */
    public ITimeSpan getTimeSpan(){
        return duration;
    }
    /**
     * 
     * @return Returns een lijst met uitgenodigde mensen in een List<Contact> formaat
     * @author Kevin Berendsen
     */
    public Iterator<Contact> invitees(){
        return invitedPeople.iterator();
    }
    
    /**
     * 
     * @param c de contact die toegevoegd moet worden
     * @return true als het gelukt is. True wordt alleen gereturned als de contact geen andere afspraak heeft op het zelfde tijdstip.
     * @author Kevin Berendsen
     */
    public boolean addContact(Contact c){
        if(!c.addAppointment(this))
            return false;
        
        invitedPeople.add(c);
        return true;
    }
    
    /**
     * 
     * @param c Verwijdered C uit de lijst.
     * @author Kevin Berendsen
     */
    public void removeContact(Contact c){
        if(invitedPeople.contains(c))
            invitedPeople.remove(c);
    }
    
    
}
