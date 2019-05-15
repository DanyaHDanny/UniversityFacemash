package by.bsuir.facemash.exception;

import org.springframework.stereotype.Component;

/**
 * Exception for case when entity already exist.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Component
public final class EntityAlreadyExistException extends RuntimeException {

    private final String errorKey;
    private final String name;

    public EntityAlreadyExistException() {
        this.errorKey = null;
        this.name = null;
    }

    public EntityAlreadyExistException(final String errorKey, final String name) {
        this.errorKey = errorKey;
        this.name = name;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public String getName() {
        return name;
    }

}
