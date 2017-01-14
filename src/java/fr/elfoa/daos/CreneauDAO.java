/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.daos;


import fr.elfoa.entities.Creneau;
import fr.elfoa.entities.Medecin;
import fr.elfoa.entities.RDV;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vagrant
 */
@Stateless
public class CreneauDAO {
    
    @PersistenceContext
    EntityManager em;

    public CreneauDAO() {
    }
    
    public List<Creneau> getFree() {
        return em.createQuery("SELECT c FROM Creneau c WHERE c.id NOT IN ("+ 
                                "SELECT DISTINCT r.creneau.id FROM RDV r" + 
                              ")", Creneau.class).getResultList();
    }
    
    public List<Creneau> get() {
        return em.createQuery("SELECT c FROM Creneau c", Creneau.class).getResultList();
    }
    
    public Creneau get(int id) {
        Creneau find = em.find(Creneau.class, id);
        
        return find;
    }
    
    public Creneau create(Date begin, Date end, Medecin medecin) {
        Creneau creneau = new Creneau(begin, end, medecin);
        em.persist(creneau);
        return (creneau); 
    }
    
    public Creneau update(int id, Date begin, Date end, Medecin medecin) {
        Creneau creneau = get(id);
        if(creneau != null) {
            if (begin != null)      creneau.setBegin(begin);
            if (end != null)        creneau.setEnd(end);
            if (medecin != null)    creneau.setMedecin(medecin);
            em.merge(creneau);
        }
        return (creneau); 
    }
    
    public void delete(int id) {
        Creneau creneau = get(id);
        if(creneau != null) em.remove(creneau);
    }
    
    public void reserver(int id, RDV rdv) {
        Creneau creneau = get(id);
        if(creneau != null) {
            creneau.setRdv(rdv);
            em.merge(creneau);
        }
    }
    
    public void annuler(int id) {
        reserver(id,null);
    }
}
