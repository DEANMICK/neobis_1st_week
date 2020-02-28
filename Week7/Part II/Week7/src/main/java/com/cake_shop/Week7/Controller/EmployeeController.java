package com.cake_shop.Week7.Controller;


import com.cake_shop.Week7.Entity.Employee;
import com.cake_shop.Week7.Repository.EmployeeRepository;
import com.cake_shop.Week7.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable ("id") Integer id) throws Exception{
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByName(@PathVariable("name") String name){
        if(name.equals("")){
            return null;
        }
        else {
            return employeeService.findByName(name);
        }
    }

    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public List<Employee> getEmployeeBySurname(@PathVariable("surname") String surname){
        if(surname.equals("")){
            return null;
        }
        else {
            return employeeService.findBySurname(surname);
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options(){
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST,
                        HttpMethod.DELETE, HttpMethod.PUT)
                .build();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable ("id") Integer id){
        employeeService.deleteById(id);
    }


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public @ResponseBody String addNewEmployee (@RequestParam String name, @RequestParam String surname,
                                                @RequestParam String phone, @RequestParam String address,
                                                @RequestParam int age, @RequestParam double salary,
                                                @RequestParam String position) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPhone(phone);
        employee.setAddress(address);
        employee.setAge(age);
        employee.setSalary(salary);
        employee.setPosition(position);
        employeeRepository.save(employee);
        return "Saved :)";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) throws Exception{
        return employeeService.changeByID(id, employee);
    }
}
