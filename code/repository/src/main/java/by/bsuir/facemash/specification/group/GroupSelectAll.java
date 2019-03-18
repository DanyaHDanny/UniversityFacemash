package by.bsuir.facemash.specification.group;

import by.bsuir.facemash.entity.Group;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification}
 * <p>for select all objects {@link Group} from database</p>.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class GroupSelectAll implements SqlSpecification {

    private static final String FIELD_ACTIVE = "active";

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);

        query.select(root).where(builder.equal(root.get(FIELD_ACTIVE), true));
        return entityManager.createQuery(query);
    }

}
