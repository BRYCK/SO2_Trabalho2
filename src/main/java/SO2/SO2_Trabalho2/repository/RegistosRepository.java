package SO2.SO2_Trabalho2.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import SO2.SO2_Trabalho2.model.Registos;

public interface RegistosRepository extends CrudRepository<Registos, Long> {
    List<Registos> findById(int id);
}