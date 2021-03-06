package fr.elfoa.entities;

import java.util.List;

public class Medecin extends Personne{
    public Medecin(String nom, String prenom){
        super(nom, prenom);
    }
    
    public Medecin(){
        super();
    }
    
    private List<Creneaux> creneaux;

    public List<Creneaux> getCreneaux() {
        return creneaux;
    }
    
    
    @Override
    public String toString(){
         return "Le medecin est " + getPrenom() +" " + getNom();
    }
    
  
    
    
}