package by.bsuir.facemash.specification.speciality;

import by.bsuir.facemash.entity.Speciality;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification} for select speciality by name.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class SpecialitySelectByName implements SqlSpecification {

    private static final String FIELD_NAME = "name";
    private String name;

    public SpecialitySelectByName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Speciality> query = builder.createQuery(Speciality.class);
        Root<Speciality> root = query.from(Speciality.class);

        query.select(root).where(builder.equal(root.get(FIELD_NAME), name));
        return entityManager.createQuery(query);
    }

}
