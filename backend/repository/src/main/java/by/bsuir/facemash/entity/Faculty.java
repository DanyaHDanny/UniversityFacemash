package by.bsuir.facemash.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity class that stores info about faculty.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<Speciality> specialities;

    public Faculty() {
        specialities = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        boolean result;
        Faculty faculty;

        if (object != null) {
            faculty = (Faculty) object;
            if (this == object) {
                result = false;
            } else if (getClass() != object.getClass()) {
                result = false;
            } else {
                result = Objects.equals(id, faculty.id) &&
                        Objects.equals(name, faculty.name) &&
                        Objects.equals(active, faculty.active);
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
        return Objects.hash(id, name, active);
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final List<Speciality> specialities) {
        this.specialities = specialities;
    }

}
