package by.bsuir.facemash.specification.group;

import by.bsuir.facemash.entity.Group;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification} for select group by name.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class GroupSelectByName implements SqlSpecification {

    private static final String FIELD_NAME = "name";
    private String name;

    public GroupSelectByName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);

        query.select(root).where(builder.equal(root.get(FIELD_NAME), name));
        return entityManager.createQuery(query);
    }

}
