package at.struct.wasbug19;

import at.struct.wasbug19.entities.SimpleEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

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

        int enumLength = MyEnum.values().length;

        for (int i = 0; i < count; i++) {
            em.persist(new SimpleEntity("name" + i, i, ThreadLocalRandom.current().nextDouble(), MyEnum.values()[ThreadLocalRandom.current().nextInt(enumLength)]));
        }
    }
}
