package SO2.SO2_Trabalho2.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Registos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Instant data;
    private int ocupacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Login login;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Lojas loja;

    protected Registos() {
    }

    public Registos(Login login, Lojas loja, int ocupacao, Instant data) {
        super();
        this.login = login;
        this.loja = loja;
        this.ocupacao = ocupacao;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Loja[id=%d, dono='%d', loja='%s', data='%s', ocupacap='%d']", id, login, loja,
                data.toString(), ocupacao);
    }

    public long getId() {
        return this.id;
    }

    public Login getDono() {
        return this.login;
    }

    public Lojas getLoja() {
        return this.loja;
    }

    public int getOcupacao() {
        return this.ocupacao;
    }

    public Instant getData() {
        return this.data;
    }

    public void setId(int set) {
        this.id = set;
    }

    public void setDono(Login set) {
        this.login = set;
    }

    public void setLoja(Lojas set) {
        this.loja = set;
    }

    public void setOcupacao(int set) {
        this.ocupacao = set;
    }

    public void setData(Instant set) {
        this.data = set;
    }

}