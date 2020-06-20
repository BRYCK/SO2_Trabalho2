package SO2.SO2_Trabalho2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SO2.SO2_Trabalho2.model.Registo;

@Repository
public interface RegistoRepository extends JpaRepository<Registo, Long> {
    //@Query("select r from Registo r where r.loja.id= :lojaNome AND r.data>=: currTime")
    //public List<Registo> findRegistoLastHour(long lojaNome,long currTime);

}