package by.bsuir.facemash.specification.api;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Interface for sql specification.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface SqlSpecification {

    /**
     * This method build sql query.
     *
     * @param entityManager value of the object {@link EntityManager}
     * @return value of the object {@link Query}
     */
    Query buildQuery(EntityManager entityManager);

}
