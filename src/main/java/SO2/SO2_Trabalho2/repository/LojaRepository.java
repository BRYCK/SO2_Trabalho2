package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;
import SO2.SO2_Trabalho2.model.Utilizador;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
    @Query("select r from Registo r where r.data>= :currTime and r.loja.id = :lojaId")
    public List<Registo> findRegistoLastHour(long currTime, long lojaId);

    public Loja findByUtilizador(Utilizador utilizador);
}