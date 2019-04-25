package by.bsuir.facemash.dto;

import by.bsuir.facemash.entity.Estimate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Dto class for entity {@link Estimate}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public class EstimateDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Short mark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private LocalDateTime dateOfLabWork;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Short getMark() {
        return mark;
    }

    public void setMark(final Short mark) {
        this.mark = mark;
    }

    public LocalDateTime getDateOfLabWork() {
        return dateOfLabWork;
    }

    public void setDateOfLabWork(final LocalDateTime dateOfLabWork) {
        this.dateOfLabWork = dateOfLabWork;
    }

}
