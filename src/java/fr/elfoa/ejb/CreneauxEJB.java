/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.ejb;

import fr.elfoa.entities.Creneaux;
import fr.elfoa.entities.Medecin;
import fr.elfoa.entities.RendezVous;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author Eloise
 */
public class CreneauxEJB {
    private EntityManager em;
    
    public Creneaux get(int id){
        return em.find(Creneaux.class, id);
    }
    
    
    public Creneaux create(Date debut, Date fin, Medecin medecin){
        Creneaux c = new Creneaux(debut, fin, medecin);
        em.persist(c);
        return c;
    }
    
    public Creneaux update(int id, Date debut, Date fin, Medecin medecin){
        Creneaux c = get(id);
        if(c!=null){
            if(debut!=null)
                c.setDebut(debut);
            if(fin!=null)
                c.setFin(fin);
            if(medecin!=null)
                c.setMedecin(medecin);
            em.merge(c);
        }   
        return c;
    }
    
    public void delete(int id){
        Creneaux c = get(id);
        if(c!=null)
            em.remove(c);
    }
    
    
    public void reserver(int id, RendezVous rdv){
        Creneaux c = get(id);
        if(c!=null){
            c.setRdv(rdv);
            em.merge(c);
        }
    }
    
    
    public void annuler(int id){
        reserver(id,null);
    }
    
    
}
