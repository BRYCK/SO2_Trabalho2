package SO2.SO2_Trabalho2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lojas {
    

    @Id
    private int id;
    private String loja;
    private int tamanho;
    private String local;

    public Lojas(int id , String loja, int tamanho, String local){
        super();
        this.id=id;
        this.loja=loja;
        this.tamanho=tamanho;
        this.local=local;
    }

    public int getId(){
        return this.id;
    }

    public String getLoja(){
        return this.loja;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public String getLocal(){
        return this.local;
    }

    public void setId(int set){
        this.id=set;
    }

    public void setLoja(String set){
        this.loja=set;
    }

    public void setTamanho(int set){
        this.tamanho=set;
    }

    public void setLocal(String set){
        this.local=set;
    }

}