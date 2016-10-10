package at.struct.wasbug21;

import at.struct.wasbug21.entities.SimpleEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.joda.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Transactional
public class SimpleService {

    private @Inject EntityManager em;


    /**
     * Writes {@code count} data to the database
     *
     * @param count
     */
    public void insertData(int count) {

        for (int i = 0; i < count; i++) {
            em.persist(new SimpleEntity("name" + i, i, ThreadLocalRandom.current().nextDouble(), LocalDate.now().minusDays(i)));
        }
    }
}
