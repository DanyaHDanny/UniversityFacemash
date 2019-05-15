package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Subject;
import by.bsuir.facemash.repository.SubjectRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Subject}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Subject create(final Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subject update(final Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        entityManager.remove(entityManager.find(Subject.class, id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Subject> findById(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        return subject != null ? Optional.of(subject) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Subject> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
