package SO2.SO2_Trabalho2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import SO2.SO2_Trabalho2.model.Lojas;

public interface LojasRepository extends JpaRepository<Lojas, Long> {
    ArrayList<Lojas> findById(int id);

    // ArrayList<Lojas> findLojas();
}