
import java.util.List;

public class Patient extends Personne{
    public Patient(String nom, String prenom){
        super(nom, prenom);
    }
    
    public Patient(){
        super();
    }
    
    private List<RendezVous> rdv;
    
    public List<RendezVous> getRdv(){
        return rdv;
    }
    
}