package by.bsuir.facemash.specification.subject;

import by.bsuir.facemash.entity.Subject;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification}
 * <p>for select all entity objects {@link Subject} from database.</p>
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class SubjectSelectAll implements SqlSpecification {

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
        Root<Subject> root = query.from(Subject.class);

        query.select(root);
        return entityManager.createQuery(query);
    }

}
