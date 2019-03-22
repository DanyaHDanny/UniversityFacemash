package by.bsuir.facemash.entity;

import by.bsuir.facemash.enumeration.UserRole;

import javax.persistence.*;
import java.util.Objects;

/**
 * This entity class store info about user.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Entity
@Table(name = "university_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", length = 20, nullable = false, unique = true)
    private String login;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role", length = 14, nullable = false)
    private UserRole userRole;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        boolean result;
        User user;

        if (object != null) {
            user = (User) object;
            if (this == object) {
                result = true;
            } else if (getClass() != object.getClass()) {
                result = false;
            } else {
                result = Objects.equals(id, user.id) &&
                        Objects.equals(login, user.login) &&
                        Objects.equals(password, user.password) &&
                        userRole == user.userRole &&
                        Objects.equals(firstName, user.firstName) &&
                        Objects.equals(lastName, user.lastName) &&
                        Objects.equals(active, user.active);
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
        return Objects.hash(id, login, password, userRole, firstName, lastName, active);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(final UserRole userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

}
