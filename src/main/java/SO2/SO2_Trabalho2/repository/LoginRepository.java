package SO2.SO2_Trabalho2.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import SO2.SO2_Trabalho2.model.Login;

public interface LoginRepository extends CrudRepository<Login, Long> {
    List<Login> findById(int id);

    List<Login> findAll();
}