package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto class for entity {@link Subject}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class SubjectDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
