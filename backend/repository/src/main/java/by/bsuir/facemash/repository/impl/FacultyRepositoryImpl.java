package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.Faculty;
import by.bsuir.facemash.repository.FacultyRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link Faculty}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class FacultyRepositoryImpl implements FacultyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Faculty create(final Faculty faculty) {
        entityManager.persist(faculty);
        return faculty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Faculty update(final Faculty faculty) {
        entityManager.merge(faculty);
        return faculty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        Faculty faculty = entityManager.find(Faculty.class, id);
        faculty.setActive(false);
        entityManager.merge(faculty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Faculty> findById(final Long id) {
        Faculty faculty = entityManager.find(Faculty.class, id);
        return faculty != null ? Optional.of(faculty) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Faculty> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
