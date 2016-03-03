package at.struct.wasbug19;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
//X @Transactional
public class LoadService {

    private @Inject EntityManager em;


    public List<Report> loadData() {
        return em.createQuery("SELECT new " + Report.class.getName() + "(s.id," +
                                                                        "s.name," +
                                                                        "s.aInteger) " +
                                      "FROM SimpleEntity AS s WHERE " +
                                          "s.name like :name", Report.class)
                 .setParameter("name", "name%")
                 .getResultList();

    }

}
