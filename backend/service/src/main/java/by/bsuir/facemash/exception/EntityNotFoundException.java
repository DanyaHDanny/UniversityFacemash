package by.bsuir.facemash.exception;

import org.springframework.stereotype.Component;

/**
 * Exception for case when entity not found by id.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Component
public final class EntityNotFoundException extends RuntimeException {

    private final String errorKey;
    private final Long id;

    public EntityNotFoundException() {
        this.errorKey = null;
        this.id = null;
    }

    public EntityNotFoundException(final String errorKey, final Long id) {
        this.errorKey = errorKey;
        this.id = id;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public Long getId() {
        return id;
    }

}
