package at.struct.wasbug19;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {


    //X DAMNIT! this triggers just another ugly bug in WAS :( private @Inject @PersistenceUnitName(value = "simple-pu") EntityManagerFactory emf;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("simple-pu");


    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }


    public void closeEntityManager(@Disposes EntityManager em) {

        if (em != null) {
            em.close();
        }
    }
}
