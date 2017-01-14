/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.daos;


import fr.elfoa.entities.Personne;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.elfoa.remote.RemotePersonne;

/**
 *
 * @author vagrant
 */
@Remote(RemotePersonne.class)
public abstract class PersonneDAO implements RemotePersonne {
    
    @PersistenceContext
    EntityManager em;

    public PersonneDAO() {
    }
    
    @Override
    public Personne get(int id) {
        Personne find = em.find(Personne.class, id);
        System.out.println(find);
        return find;
    }

    @Override
    public Personne update(int id, String name, String firstName) {
        Personne personne = get(id);
        if(personne != null) {
            if (name != null) personne.setName(name);
            if (firstName != null) personne.setFirstName(firstName);
            em.merge(personne);
        }
        return (personne);
    }

    @Override
    public void delete(int id) {
        Personne personne = get(id);
        if(personne != null) em.remove(personne);
    }
    
}
