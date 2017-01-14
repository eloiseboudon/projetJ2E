/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.daos;


import fr.elfoa.entities.Creneau;
import fr.elfoa.entities.Patient;
import fr.elfoa.entities.RDV;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.elfoa.remote.RemotePersonne;

/**
 *
 * @author vagrant
 */
@Stateless
public class RDVDAO {
    
    @PersistenceContext
    EntityManager em;

    public RDVDAO() {
    }
    
    public List<RDV> get() {
        return em.createQuery("SELECT r FROM RDV r", RDV.class).getResultList();
    }
    
    public RDV get(int id) {
        return em.find(RDV.class, id);
    }
    
    public RDV create(Patient patient, Creneau creneau) {
        RDV rdv = new RDV(patient, creneau);
        em.persist(rdv);
        return (rdv); 
    }
    
    public RDV update(int id, Creneau creneau, Patient patient) {
        RDV rdv = get(id);
        if (creneau != null) rdv.setCreneau(creneau);
        if (patient != null) rdv.setPatient(patient);
        em.merge(rdv);
        return (rdv); 
    }
    
    public void delete(int id) {
        RDV rdv = get(id);
        em.remove(rdv);
    }
    
}
