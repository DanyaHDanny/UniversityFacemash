package by.bsuir.facemash.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This entity class store value of the laboratory estimate.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Entity
@Table(name = "estimate")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mark", nullable = false)
    private Short mark;

    @Column(name = "date_lab_work", nullable = false)
    private LocalDateTime dateOfLabWork;

    @Override
    public String toString() {
        return "estimate{" +
                "id=" + id +
                ", mark=" + mark +
                ", dateOfLabWork=" + dateOfLabWork +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        boolean result;
        Estimate estimate;

        if (object != null) {
            estimate = (Estimate) object;
            if (this == object) {
                result = true;
            } else if (getClass() != object.getClass()) {
                result = false;
            } else {
                result = Objects.equals(id, estimate.id) &&
                        Objects.equals(mark, estimate.mark) &&
                        Objects.equals(dateOfLabWork, estimate.dateOfLabWork);
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, mark, dateOfLabWork);
    }

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
