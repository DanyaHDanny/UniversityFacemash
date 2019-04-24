package by.bsuir.facemash.specification.subject;

import by.bsuir.facemash.entity.Subject;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification} for select objects {@link Subject} by name.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class SubjectSelectByName implements SqlSpecification {

    private static final String FIELD_NAME = "name";
    private String name;

    public SubjectSelectByName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
        Root<Subject> root = query.from(Subject.class);

        query.select(root).where(builder.equal(root.get(FIELD_NAME), name));
        return entityManager.createQuery(query);
    }

}
