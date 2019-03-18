package by.bsuir.facemash.entity;

import javax.persistence.*;

/**
 * Entity class that store info about study group.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Entity
@Table(name = "study_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
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
