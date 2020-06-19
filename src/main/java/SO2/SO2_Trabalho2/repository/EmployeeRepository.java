package SO2.SO2_Trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SO2.SO2_Trabalho2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}