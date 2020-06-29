package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SO2.SO2_Trabalho2.model.Utilizador;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

    Utilizador findByUtilizador(String username);

    Utilizador findById(long id);

}