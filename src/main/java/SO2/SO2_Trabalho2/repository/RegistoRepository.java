package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SO2.SO2_Trabalho2.model.Registo;

@Repository
public interface RegistoRepository extends JpaRepository<Registo, Long> {

}