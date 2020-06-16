package SO2.SO2_Trabalho2;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Registos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String loja;
    private int ocupacao;
    private Date data;

    public Registos(int id, String loja, int ocupacao, Date data) {
        super();
        this.id = id;
        this.loja = loja;
        this.ocupacao = ocupacao;
        this.data = data;
    }

    public int getId() {
        return this.id;
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