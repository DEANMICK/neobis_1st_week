package kg.neobis.Week6.repository;

import kg.neobis.Week6.Entity.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
