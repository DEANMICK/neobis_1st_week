 package com.cake_shop.Week7.Controller;


import com.cake_shop.Week7.Entity.Employee;
import com.cake_shop.Week7.Repository.EmployeeRepository;
import com.cake_shop.Week7.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

 @CrossOrigin
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping(path = "/addEmployee")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping(path = "/allEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployee(@PathVariable ("id") Integer id) throws Exception{
        return employeeService.findById(id);
    }

    @GetMapping(path = "/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String name){
        if(name.equals("")){
            return null;
        }
        else {
            return employeeService.findByName(name);
        }
    }


    @GetMapping(path = "/surname/{surname}")
    public List<Employee> getEmployeeBySurname(@PathVariable("surname") String surname){
        if(surname.equals("")){
            return null;
        }
        else {
            return employeeService.findBySurname(surname);
        }
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ("id") Integer id){
        try {
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }



    @PutMapping(path = "/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) throws Exception{
        return employeeService.changeByID(id, employee);
    }

}
