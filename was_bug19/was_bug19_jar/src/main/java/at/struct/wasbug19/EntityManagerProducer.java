package at.struct.wasbug19;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit(unitName = "simple-pu")
    private EntityManagerFactory emf;

    //X DAMNIT! this triggers just another ugly bug in WAS :( private @Inject @PersistenceUnitName(value = "simple-pu") EntityManagerFactory emf;

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
