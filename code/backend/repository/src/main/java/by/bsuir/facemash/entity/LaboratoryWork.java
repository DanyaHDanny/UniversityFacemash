package by.bsuir.facemash.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * This entity class store info laboratory work.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Entity
@Table(name = "laboratory_work")
public class LaboratoryWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_comment_id", nullable = false)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estimate_id", nullable = false)
    private Estimate estimate;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "LaboratoryWork{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        boolean result;
        LaboratoryWork laboratoryWork;

        if (object != null) {
            laboratoryWork = (LaboratoryWork) object;
            if (this == object) {
                result = true;
            } else if (getClass() != object.getClass()) {
                result = false;
            } else {
                result = Objects.equals(id, laboratoryWork.id) &&
                        Objects.equals(description, laboratoryWork.description);
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
        return Objects.hash(id, description);
    }

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(final Comment comment) {
        this.comment = comment;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(final Estimate estimate) {
        this.estimate = estimate;
    }

}
