package com.cake_shop.Week7.Repository;

import com.cake_shop.Week7.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContaining(String name);

    List<Employee> findBySurnameContaining(String surname);
}
