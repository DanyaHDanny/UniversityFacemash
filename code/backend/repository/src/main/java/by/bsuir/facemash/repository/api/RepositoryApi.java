package by.bsuir.facemash.repository.api;

import by.bsuir.facemash.specification.api.SqlSpecification;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface with basic methods.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface RepositoryApi<T> {

    /**
     * This method add entity object in database.
     *
     * @param object value of the entity object
     * @return value of the added object
     */
    T create(T object);

    /**
     * This method update entity object in database.
     *
     * @param object value of the entity object
     * @return value of the update object
     */
    T update(T object);

    /**
     * This method delete entity object from database.
     *
     * @param id value of the entity id
     */
    void delete(Long id);

    /**
     * This method find entity object by id.
     *
     * @param id value of the entity id
     * @return value of the entity object
     */
    Optional<T> findById(Long id);

    /**
     * This select entity objects by some specification.
     *
     * @param sqlSpecification value of the object {@link SqlSpecification}
     * @return list of the entity objects
     */
    List<T> query(SqlSpecification sqlSpecification);

}
