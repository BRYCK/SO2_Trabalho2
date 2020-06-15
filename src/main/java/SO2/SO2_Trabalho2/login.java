package SO2.SO2_Trabalho2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class login {
    

    @Id
    private String user;
    private String password;
    private int id;

    public login(String user, String password, int id){
        super();
        this.user= user;
        this.password=password;
        this.id=id;
    }

    public String getUser(){
        return this.user;
    }

    public String getPassword(){
        return this.password;
    }

    public int getId(){
        return this.id;
    }

    public void setUser(String set){
        this.user=set;
    }

    public void setPassword(String set){
        this.password=set;
    }

    public void setId(int set){
        this.id=set;
    }


    
    
}