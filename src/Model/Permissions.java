package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permissions",schema = "",catalog = "My_db")
//@IdClass(Permissions1.class)
public class Permissions implements Serializable {

    private String role;
    private String permission;

    public Permissions(){}


    public void setRole(String role){
        this.role = role;
    }
    @Id
    @Column(name="role")
    public String getRole(){ return this.role; }


    public void setPermission(String permission){
        this.permission = permission;
    }
    @Id
    @Column(name ="permission")
    public String getPermission(){ return this.permission; }

}
