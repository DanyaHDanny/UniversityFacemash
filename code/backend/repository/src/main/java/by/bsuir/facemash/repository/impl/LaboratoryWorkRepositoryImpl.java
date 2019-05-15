package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.LaboratoryWork;
import by.bsuir.facemash.repository.LaboratoryWorkRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link LaboratoryWork}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class LaboratoryWorkRepositoryImpl implements LaboratoryWorkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public LaboratoryWork create(final LaboratoryWork laboratoryWork) {
        entityManager.persist(laboratoryWork);
        return laboratoryWork;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LaboratoryWork update(final LaboratoryWork laboratoryWork) {
        entityManager.merge(laboratoryWork);
        return laboratoryWork;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        entityManager.remove(entityManager.find(LaboratoryWork.class, id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<LaboratoryWork> findById(final Long id) {
        LaboratoryWork laboratoryWork = entityManager.find(LaboratoryWork.class, id);
        return laboratoryWork != null ? Optional.of(laboratoryWork) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LaboratoryWork> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
