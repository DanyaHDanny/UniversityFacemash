package by.bsuir.facemash.service.api;

import java.util.List;

/**
 * Service interface with basic methods for work with repository.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface ServiceApi<T> {

    /**
     * This method add dto object.
     *
     * @param object value of the dto object
     * @return value of the dto object
     */
    T add(T object);

    /**
     * This method remove dto object by id.
     *
     * @param id value of the dto object id
     */
    void remove(Long id);

    /**
     * This method update dto object.
     *
     * @param object value of the dto object
     * @return value of the update dto object
     */
    T update(T object);

    /**
     * This method get dto object by id.
     *
     * @param id value of the dto object id
     * @return value of the dto object
     */
    T findById(Long id);

    /**
     * This method get all dto objects.
     *
     * @return list of the dto objects
     */
    List<T> findAll();

}
