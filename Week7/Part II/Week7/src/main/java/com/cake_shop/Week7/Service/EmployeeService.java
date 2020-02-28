package com.cake_shop.Week7.Service;


import com.cake_shop.Week7.Entity.Employee;
import com.cake_shop.Week7.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) throws Exception{
        return employeeRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> findBySurname(String surname){
        return employeeRepository.findBySurnameContaining(surname);
    }

    public String deleteById(Integer id){
        employeeRepository.deleteById(id);
        return "Employee id = " + id + " has been fired!";
    }


    public Employee changeByID(Integer id, Employee employee) throws Exception{
        return employeeRepository.findById(id)
                .map(newEmployee->{
                    newEmployee.setId(employee.getId());
                    newEmployee.setName(employee.getName());
                    newEmployee.setSurname(employee.getSurname());
                    newEmployee.setPhone(employee.getPhone());
                    newEmployee.setAddress(employee.getAddress());
                    newEmployee.setAge(employee.getAge());
                    newEmployee.setSalary(employee.getSalary());
                    newEmployee.setPosition(employee.getPosition());
                    return employeeRepository.save(employee);
                }).orElseThrow(Exception::new);
    }

}
