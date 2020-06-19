package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import SO2.SO2_Trabalho2.model.Registos;

public interface RegistosRepository extends JpaRepository<Registos, Long> {
    // @Query("from Registos r join r.login l where l.utilizador=:User")
    public Iterable<Registos> findByUser(String User);

    @Query("from Registos r join r.login l where l.utilizador=:User and r.data >= hour")
    public Iterable<Registos> findByTime(long hour);
    // 1 hora em milisegundos 3600000
}