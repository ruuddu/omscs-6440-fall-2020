package gatech.scrubs26.hypertensionmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`") // user is the preserved keyword in PostgreSQL so we have to escape it
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    // Transient keyword means the variable won't be persisted in DB
    @Transient
    private String passwordConfirm;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<DietEntry> dietEntries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
