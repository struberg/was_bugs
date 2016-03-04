package at.struct.wasbug19;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class WorkingLoadService {

    private @Inject EntityManager em;


    public List<ResultWrapper> load() {
        return em.createQuery("SELECT new " + ResultWrapper.class.getName() + "(s.id," +
                                                                               "s.name) " +
                                      "FROM SimpleEntity AS s", ResultWrapper.class)
                 .getResultList();
    }
}
