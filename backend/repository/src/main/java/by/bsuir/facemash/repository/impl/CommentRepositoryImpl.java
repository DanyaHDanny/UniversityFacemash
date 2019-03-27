package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Comment;
import by.bsuir.facemash.repository.CommentRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Comment}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Comment create(final Comment comment) {
        entityManager.persist(comment);
        return comment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comment update(final Comment comment) {
        entityManager.merge(comment);
        return comment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        entityManager.remove(entityManager.find(Comment.class, id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comment> findById(final Long id) {
        Comment comment = entityManager.find(Comment.class, id);
        return comment != null ? Optional.of(comment) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Comment> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
