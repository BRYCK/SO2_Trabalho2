package SO2.SO2_Trabalho2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import SO2.SO2_Trabalho2.enumAux.Role;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    private long id;
    private String utilizador;
    private Role role;

    public Utilizador() {

    }

    public Utilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "utilizador", nullable = false, unique = true)
    public String getUtilizador() {
        return this.utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}