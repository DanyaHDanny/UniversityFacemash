package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Group;

/**
 * Dto class for entity {@link Group}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class GroupDto {

    private Long id;
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
