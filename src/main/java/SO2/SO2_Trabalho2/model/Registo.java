package SO2.SO2_Trabalho2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registo")
public class Registo {

    private long id;
    private long data;
    private String ocupacao;
    private Loja loja;

    public Registo() {

    }

    public Registo(long data, String ocupacao, Loja loja) {
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
    public long getData() {
        return this.data;
    }

    public void setData(long data) {
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
    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}