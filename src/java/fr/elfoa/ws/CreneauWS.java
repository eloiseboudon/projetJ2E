package fr.elfoa.ws;
import fr.elfoa.daos.CreneauDAO;
import fr.elfoa.entities.Patient;
import fr.elfoa.daos.RDVDAO;
import fr.elfoa.entities.Creneau;
import fr.elfoa.entities.RDV;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import fr.elfoa.remote.RemotePersonne;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("creneau")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreneauWS {
    @EJB
    private CreneauDAO cdao;
    
    @EJB
    private RDVDAO rdao;
    
    @EJB(mappedName = "patientDAO")
    private RemotePersonne<Patient> pdao;

    private final EntityManager em;

    public CreneauWS() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersitanceUnit");
        em = emf.createEntityManager();
    }
    
    @Path("free")
    @GET
    public List<Creneau> getCreneauLibre() throws SQLException {       
        List<Creneau> creneaux = cdao.getFree();
        return creneaux;    
    }
    
    @GET
    public List<Creneau> getCreneau() throws SQLException {       
        return cdao.get();
    }
  
    @Path("{id}")
    @GET
    public Creneau getCreneau(@PathParam("id") int id) throws SQLException {       
        return cdao.get(id);
    }

    @Path("{id}")
    @PUT
    public void updateCreneau(@PathParam("id") int id, Creneau creneau) throws SQLException, ParseException {
        cdao.update(id,creneau.getBegin(), creneau.getEnd(),creneau.getMedecin());  
    }

    @Path("{id}")
    @DELETE
    public void deleteCreneau(@PathParam("id") int id) throws SQLException {
        cdao.delete(id);
    }
    
    @Path("{id}/reserver")
    @POST
    public void reserverCreneau(@PathParam("id") int id, Patient patient) throws SQLException {
        RDV rdv = rdao.create(pdao.get(patient.getId()), cdao.get(id));
        
        cdao.reserver(id, rdv);
    }
    
    @Path("{id}/annuler")
    @POST
    public void annulerCreneau(@PathParam("id") int id) throws SQLException {
        Creneau creneau = cdao.get(id);
        if (creneau != null) rdao.delete(creneau.getRDV().getId());
        
        cdao.annuler(id);
    }
}
