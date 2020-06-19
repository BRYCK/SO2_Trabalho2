package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import SO2.SO2_Trabalho2.model.Registos;

public interface RegistosRepository extends CrudRepository<Registos, Long> {
    @Query("from Registos r join r.login l where r.utilizador=:User")
    public Iterable<Registos> findByUser(String User);
}