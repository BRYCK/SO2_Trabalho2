package SO2.SO2_Trabalho2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "registo")
public class Registo {

    private long id;
    private Timestamp data;
    private String ocupacao;
    private Loja loja;

    public Registo() {

    }

    public Registo(Timestamp data, String ocupacao, Loja loja) {
        this.data = data;
        this.ocupacao = ocupacao;
        this.loja = loja;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "data", nullable = false)
    public Timestamp getData() {
        return this.data;
    }

    public void setData(long data) {
        this.data = new Timestamp(data);
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Column(name = "ocupacao", nullable = false)
    public String getOcupacao() {
        return this.ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}