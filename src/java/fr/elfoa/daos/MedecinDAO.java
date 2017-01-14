/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.daos;


import fr.elfoa.entities.Medecin;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import fr.elfoa.remote.RemotePersonne;

/**
 *
 * @author vagrant
 */
@Stateless(mappedName = "medecinDAO")
@Remote(RemotePersonne.class)
public class MedecinDAO extends PersonneDAO implements RemotePersonne {

    public MedecinDAO() {
    }
    
    @Override
    public List<Medecin> get() {
        return em.createQuery("SELECT m FROM Medecin m", Medecin.class).getResultList();
    }
    
    @Override
    public Medecin create(String name, String firstName) {
        Medecin medecin = new Medecin(name, firstName);
        em.persist(medecin);
        return (medecin); 
    }
    
}
