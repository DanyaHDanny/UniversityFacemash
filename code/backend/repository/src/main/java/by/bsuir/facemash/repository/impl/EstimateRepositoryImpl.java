package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Estimate;
import by.bsuir.facemash.repository.EstimateRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Estimate}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class EstimateRepositoryImpl implements EstimateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Estimate create(final Estimate estimate) {
        entityManager.persist(estimate);
        return estimate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Estimate update(final Estimate estimate) {
        entityManager.merge(estimate);
        return estimate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        entityManager.remove(entityManager.find(Estimate.class, id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Estimate> findById(final Long id) {
        Estimate estimate = entityManager.find(Estimate.class, id);
        return estimate != null ? Optional.of(estimate) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Estimate> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
