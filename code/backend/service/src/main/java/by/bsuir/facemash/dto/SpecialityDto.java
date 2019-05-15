package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Speciality;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto class for entity {@link Speciality}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class SpecialityDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;

}
