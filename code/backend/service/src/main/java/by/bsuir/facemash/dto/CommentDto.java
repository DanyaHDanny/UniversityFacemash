package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto class for entity {@link Comment}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class CommentDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
