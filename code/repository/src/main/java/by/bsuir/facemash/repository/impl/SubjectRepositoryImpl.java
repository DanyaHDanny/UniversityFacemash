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

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List query(SqlSpecification sqlSpecification) {
        return null;
    }
}
