package by.bsuir.facemash.specification.estimate;

import by.bsuir.facemash.entity.Estimate;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification}
 * <p>for select all entity objects {@link Estimate} from database.</p>
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class EstimateSelectAll implements SqlSpecification {

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estimate> query = builder.createQuery(Estimate.class);
        Root<Estimate> root = query.from(Estimate.class);

        query.select(root);
        return entityManager.createQuery(query);
    }

}
