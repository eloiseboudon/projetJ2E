package fr.elfoa.ws;
import fr.elfoa.entities.Patient;
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


@Path("patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientWS {
    
    @EJB(mappedName = "patientDAO")
    private RemotePersonne<Patient> pdao;

    private final EntityManager em;

    public PatientWS() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersitanceUnit");
        em = emf.createEntityManager();
    }
    
    @GET
    public List<Patient> getPatient() throws NamingException, SQLException {       
        List<Patient> patient = pdao.get();
        return patient;    
    }
  
    @Path("{id}")
    @GET
    public Patient getPatient(@PathParam("id") int id) throws NamingException, SQLException {       
        Patient patient = pdao.get(id);
        return patient;    
    }

    @POST
    public void addPatient(Patient patient) throws NamingException, SQLException {       
        pdao.create(patient.getName(), patient.getFirstName());
    }

    @Path("{id}")
    @PUT
    public void updatePatient(@PathParam("id") int id, Patient newPatient) throws NamingException, SQLException {
        pdao.update(id, newPatient.getName(), newPatient.getFirstName());
    }

    @Path("{id}")
    @DELETE
    public void deletePatient(@PathParam("id") int id) throws NamingException, SQLException {
        pdao.delete(id);  
    }
}
