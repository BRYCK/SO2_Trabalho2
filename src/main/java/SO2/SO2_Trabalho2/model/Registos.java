package SO2.SO2_Trabalho2.model;

import java.util.Date;
import java.sql.Timestamp;

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

    private long data;
    private int ocupacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Login login;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Lojas loja;

    protected Registos() {
    }

    public Registos(Login login, Lojas loja, int ocupacao) {
        super();
        this.login = login;
        this.loja = loja;
        this.ocupacao = ocupacao;
        Date date= new Date();
        long time = date.getTime();
        this.data = time;
    }

    @Override
    public String toString() {
        Timestamp time= new Timestamp(this.data);
        return String.format("Loja[id=%d, dono='%d', loja='%s', data='%s', ocupacap='%d']", id, login, loja,
                time, ocupacao);
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

    public long getData() {
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

    public void setData() {
        Date date= new Date();
        long time = date.getTime();
        this.data = time;
    }

}