package fr.elfoa.ws;
import fr.elfoa.daos.CreneauDAO;
import fr.elfoa.daos.PatientDAO;
import fr.elfoa.daos.RDVDAO;
import fr.elfoa.entities.Patient;
import fr.elfoa.entities.RDV;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import fr.elfoa.remote.RemotePersonne;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("rdv")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RDVWS {
    @EJB
    private CreneauDAO cdao;
    
    @EJB
    private RDVDAO rdao;
    
    @EJB(mappedName = "patientDAO")
    private RemotePersonne<Patient> pdao;

    private final EntityManager em;

    public RDVWS() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersitanceUnit");
        em = emf.createEntityManager();
    }
    
    @GET
    public List<RDV> getRDV() throws SQLException {       
        List<RDV> rdv = rdao.get();
        return rdv;    
    }
  
    @Path("{id}")
    @GET
    public RDV getRDV(@PathParam("id") int id) throws SQLException {       
        return rdao.get(id);
    }

    @Path("{id}")
    @PUT
    public void updateRDV(@PathParam("id") int id, RDV rdv) throws SQLException {
        rdao.update(id,rdv.getCreneau(),rdv.getPatient());
    }

    @Path("{id}")
    @DELETE
    public void deleteRDV(@PathParam("id") int id) throws SQLException {
        rdao.delete(id); 
    }
}
