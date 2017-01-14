package fr.elfoa.ws;



import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("ws")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> service = new HashSet<>();

    service.add(MedecinWS.class);
    service.add(PatientWS.class);
    service.add(CreneauWS.class);
    service.add(RDVWS.class);

    return service;
  }     
}
