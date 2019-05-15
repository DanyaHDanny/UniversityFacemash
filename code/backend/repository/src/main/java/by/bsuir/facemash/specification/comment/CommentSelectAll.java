package by.bsuir.facemash.specification.comment;

import by.bsuir.facemash.entity.Comment;
import by.bsuir.facemash.specification.api.SqlSpecification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * This class implements interface {@link SqlSpecification}
 * <p>for select all entity objects {@link Comment} from database.</p>
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class CommentSelectAll implements SqlSpecification {

    /**
     * {@inheritDoc}
     */
    @Override
    public Query buildQuery(final EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);

        query.select(root);
        return entityManager.createQuery(query);
    }

}
