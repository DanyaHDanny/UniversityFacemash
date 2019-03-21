package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Group;
import by.bsuir.facemash.repository.GroupRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Group}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Group create(final Group group) {
        entityManager.persist(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Group update(final Group group) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Group> findById(final Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Group> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }

}
