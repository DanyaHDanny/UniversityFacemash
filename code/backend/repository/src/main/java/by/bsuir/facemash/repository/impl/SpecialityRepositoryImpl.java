package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Speciality;
import by.bsuir.facemash.repository.SpecialityRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Speciality}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class SpecialityRepositoryImpl implements SpecialityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Speciality create(final Speciality speciality) {
        entityManager.persist(speciality);
        return speciality;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Speciality update(final Speciality speciality) {
        entityManager.merge(speciality);
        return speciality;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        Speciality speciality = entityManager.find(Speciality.class, id);
        speciality.setActive(false);
        entityManager.merge(speciality);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Speciality> findById(final Long id) {
        Speciality speciality = entityManager.find(Speciality.class, id);
        return speciality != null ? Optional.of(speciality) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Speciality> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
