package SO2.SO2_Trabalho2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "utilizador"))
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String utilizador;
    private String password;

    protected Login() {
    }

    public Login(String utilizador, String password) {
        super();
        this.utilizador = utilizador;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Login[id=%d, utilizador='%s', password='%s']", id, utilizador, password);
    }

    public String getUtilizador() {
        return this.utilizador;
    }

    public String getPassword() {
        return this.password;
    }

    public long getId() {
        return this.id;
    }

    public void setUtilizador(String set) {
        this.utilizador = set;
    }

    public void setPassword(String set) {
        this.password = set;
    }

    public void setId(int set) {
        this.id = set;
    }

}