package SO2.SO2_Trabalho2.model;

import java.util.Date;

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

    private Date data;
    private int ocupacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Login dono;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Lojas loja;
    

    protected Registos() {
    }

    public Registos(int dono, String loja, int ocupacao, Date data) {
        super();
        this.dono = dono;
        this.loja = loja;
        this.ocupacao = ocupacao;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Loja[id=%d, dono='%d', loja='%s', data='%s', ocupacap='%d']", id, dono, loja,
                data.toString(), ocupacao);
    }

    public long getId() {
        return this.id;
    }

    public int getDono() {
        return this.dono;
    }

    public String getLoja() {
        return this.loja;
    }

    public int getOcupacao() {
        return this.ocupacao;
    }

    public Date getData() {
        return this.data;
    }

    public void setId(int set) {
        this.id = set;
    }

    public void setDono(int set) {
        this.dono = set;
    }

    public void setLoja(String set) {
        this.loja = set;
    }

    public void setOcupacao(int set) {
        this.ocupacao = set;
    }

    public void setData(Date set) {
        this.data = set;
    }

}