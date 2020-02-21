package kg.neobis.Week6.Controller;


import kg.neobis.Week6.Entity.Employee;
import kg.neobis.Week6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }



    /*С помощью метода POST добавляю новых сотрудников по указанным параметрам(имя, фамилия,
    номер телефона, адрес, возраст, зарплата, должность). В случае удачного добавления выводит "Saved"
   */
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


    /*Метод DELETE удаляет данные из БД. В данном случае по  ID
        */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        return employeeRepository.findById(id)
                .map(record -> {
                    employeeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    /*
    * Метод PUT заменяет все текущие данные.
    *
    * */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,
                                                   @RequestBody Employee employee) {
        return employeeRepository.findById(id)
                .map(record -> {
                    record.setName(employee.getName());
                    record.setSurname(employee.getSurname());
                    record.setPhone(employee.getPhone());
                    record.setAddress(employee.getAddress());
                    record.setAge(employee.getAge());
                    record.setSalary(employee.getSalary());
                    record.setPosition(employee.getPosition());
                    Employee updated = employeeRepository.save(employee);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    /*С помощью метода GET запрашиваю данные из БД.
        Запросы с использованием GET должны только извлекать данные.
     */
    @RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
    public @ResponseBody Iterable<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
