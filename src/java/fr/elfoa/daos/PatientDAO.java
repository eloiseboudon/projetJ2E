/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.daos;


import fr.elfoa.entities.Patient;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import fr.elfoa.remote.RemotePersonne;

/**
 *
 * @author vagrant
 */
@Stateless(mappedName = "patientDAO")
@Remote(RemotePersonne.class)
public class PatientDAO extends PersonneDAO implements RemotePersonne {

    public PatientDAO() {
    }
    
    @Override
    public Patient create(String name, String firstName) {
        Patient patient = new Patient(name, firstName);
        em.persist(patient);
        return (patient); 
    }

    @Override
    public List<Patient> get() {
        return em.createQuery("SELECT m FROM Patient m", Patient.class).getResultList();
    }
    
}
