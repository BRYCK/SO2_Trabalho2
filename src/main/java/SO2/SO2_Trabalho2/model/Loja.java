package SO2.SO2_Trabalho2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "loja")
public class Loja {

    private long id;
    private String nome;
    private String local;
    private int tamanho;
    private String ocupacao;
    private Double latitude;
    private Double longitude;
    private Utilizador utilizador;
    private List<Registo> registos;

    public Loja() {

    }

    public Loja(String nome, String local, int tamanho, Utilizador utilizador, String ocupacao, Double longitude,
            Double latitude) {
        this.nome = nome;
        this.local = local;
        this.tamanho = tamanho;
        this.utilizador = utilizador;
        this.ocupacao = ocupacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Loja(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "local", nullable = false)
    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Column(name = "tamanho", nullable = false)
    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @OneToOne()
    @JoinColumn(name = "utilizador")
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    public List<Registo> getRegistos() {
        return this.registos;
    }

    public void setRegistos(List<Registo> registos) {
        this.registos = registos;
    }

    @Column(name = "ocupacao")
    public String getOcupacao() {
        return this.ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = Double.parseDouble(latitude);
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLongitude(String longitude) {
        System.out.println(longitude);
        this.longitude = Double.parseDouble(longitude);
    }

}
