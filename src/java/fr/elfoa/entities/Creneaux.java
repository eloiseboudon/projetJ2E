
package fr.elfoa.entities;

import java.util.Date;

public class Creneaux {
    private Date debut;
    private Date fin;
    private Medecin medecin;
    private RendezVous rdv;

    /**
     * @return the debut
     */
    public Date getDebut() {
        return debut;
    }

    /**
     * @param debut the debut to set
     */
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    /**
     * @return the fin
     */
    public Date getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * @return the medecin
     */
    public Medecin getMedecin() {
        return medecin;
    }

    /**
     * @param medecin the medecin to set
     */
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    /**
     * @return the rdv
     */
    public RendezVous getRdv() {
        return rdv;
    }

    /**
     * @param rdv the rdv to set
     */
    public void setRdv(RendezVous rdv) {
        this.rdv = rdv;
    }

}