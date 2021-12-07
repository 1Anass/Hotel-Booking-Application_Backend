package ma.hotelbookingapp.monolithic.data.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Authority")
public class Authority extends BaseEntity {

    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    
    @Column(name="username")
    @NotNull 
    protected String username;

    @Column(name="authority")
    @NotNull 
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    protected Authority() { }

    public Authority(String username, String authority){
        this.username = username;
        this.authority = authority;
    } 
}
