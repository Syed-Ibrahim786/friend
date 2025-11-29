package Friend_proto.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Entity
@Data
@Table(name = "userstable")
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

//    @Enumerated(EnumType.STRING)
//    private Roles role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Roles getRole() {
//        return role;
//    }
//
//    public void setRole(Roles role) {
//        this.role = role;
//    }
}
