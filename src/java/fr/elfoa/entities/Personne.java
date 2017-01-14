public class Personne{
    private String nom;
    private String prenom;
    private Integer id;
     
    public Personne(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }
    
    public Personne(){
        this.nom="non renseigne";
        this.prenom="non renseigne";
    }
    
    public Personne(Integer id){
        this.id=id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    
    
}