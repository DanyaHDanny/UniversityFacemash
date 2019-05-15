package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Group;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto class for entity {@link Group}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class GroupDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Short course;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private SpecialityDto speciality;

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

    public Short getCourse() {
        return course;
    }

    public void setCourse(final Short course) {
        this.course = course;
    }

    public SpecialityDto getSpeciality() {
        return speciality;
    }

    public void setSpeciality(final SpecialityDto speciality) {
        this.speciality = speciality;
    }

}
