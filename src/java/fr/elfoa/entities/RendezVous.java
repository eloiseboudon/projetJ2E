package fr.elfoa.entities;

import java.util.Date;

public class RendezVous{
    private Creneaux creneau;
    private Patient patient;
    private Integer id;

    public RendezVous(Patient p, Creneaux c){
        this.creneau=c;
        this.patient = p;
    }
    
    public RendezVous(){
               
    }
        
    /**
     * @return the creneau
     */
    public Creneaux getCreneau() {
        return creneau;
    }

    /**
     * @param creneau the creneau to set
     */
    public void setCreneau(Creneaux creneau) {
        this.creneau = creneau;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    
}