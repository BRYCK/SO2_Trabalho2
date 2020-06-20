package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
    @Query("select r from Registo r where r.data>= :currTime")
    public List<Registo> findRegistoLastHour(long currTime);
}