package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", catalog = "My_db", schema = "")
public class Role implements Serializable {
    private String username;
    private String role;

    public Role(){}

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role){
        this.role = role;
    }

    @Id
    @Column(name="role")
    public String getRole(){
        return role;
    }

}
