package by.bsuir.facemash.repository.impl;

import by.bsuir.facemash.entity.User;
import by.bsuir.facemash.repository.UserRepository;
import by.bsuir.facemash.specification.api.SqlSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for entity {@link User}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(final User user) {
        entityManager.persist(user);
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User update(final User user) {
        entityManager.merge(user);
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(final Long id) {
        User user = entityManager.find(User.class, id);
        user.setActive(false);
        entityManager.merge(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<User> findById(final Long id) {
        User user = entityManager.find(User.class, id);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> query(final SqlSpecification sqlSpecification) {
        return sqlSpecification.buildQuery(entityManager).getResultList();
    }
}
