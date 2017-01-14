package fr.elfoa.ws;
import fr.elfoa.daos.CreneauDAO;
import fr.elfoa.entities.Creneau;
import fr.elfoa.entities.Medecin;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;
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

@Path("medecin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedecinWS {
    
  @EJB(mappedName = "medecinDAO")
  private RemotePersonne<Medecin> mdao;
  
  @EJB
  private CreneauDAO cdao;
  
  private final EntityManager em;

    public MedecinWS() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersitanceUnit");
        em = emf.createEntityManager();
    }
    
    @GET
    public List<Medecin> getMedecin() throws NamingException, SQLException {       
        List<Medecin> medecin = mdao.get();
        return medecin;    
    }
  
    @Path("{id}")
    @GET
    public Medecin getMedecin(@PathParam("id") int id) throws NamingException, SQLException {       
        Medecin medecin = mdao.get(id);
        return medecin;    
    }

    @POST
    public void addMedecin(Medecin medecin) throws NamingException, SQLException {       
        mdao.create(medecin.getName(), medecin.getFirstName());
    }

    @Path("{id}")
    @PUT
    public void updateMedecin(@PathParam("id") int id, Medecin newMedecin) throws NamingException, SQLException {
        mdao.update(id, newMedecin.getName(), newMedecin.getFirstName());  
    }

    @Path("{id}")
    @DELETE
    public void deleteMedecin(@PathParam("id") int id) throws NamingException, SQLException {
        mdao.delete(id);  
    }
    
    @Path("{id}/creneau")
    @POST
    public void addCreneau(@PathParam("id") int id, Creneau creneau) throws NamingException, SQLException {
        cdao.create(creneau.getBegin(), creneau.getEnd(), mdao.get(id));
    }
    
}
