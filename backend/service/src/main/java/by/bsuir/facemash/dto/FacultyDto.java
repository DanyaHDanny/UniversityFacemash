package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Faculty;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Dto class for entity {@link Faculty}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class FacultyDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<SpecialityDto> specialities;

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

    public List<SpecialityDto> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final List<SpecialityDto> specialities) {
        this.specialities = specialities;
    }

}
