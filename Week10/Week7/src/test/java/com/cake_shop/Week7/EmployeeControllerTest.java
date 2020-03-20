package com.cake_shop.Week7;

import com.cake_shop.Week7.Entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Week7Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    public void testGetAllEmployee(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employee/allEmployee",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById(){
        Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/1", Employee.class);
        System.out.println(employee.getName());
        assertNotNull(employee);
    }

    @Test
    public void testDeleteEmployee(){
        int id = 17;
        Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/delete/" + id, Employee.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/employee/delete/" + id);
        try {
            employee = restTemplate.getForObject(getRootUrl() + "/employee/delete/" + id, Employee.class);
        } catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testUpdateEmployeeById(){
        int id = 20;
        Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/update/" + id, Employee.class);
        employee.setName("Name");
        employee.setSurname("Surname");
        restTemplate.put(getRootUrl() + "/employee/update/" + id, employee);
        Employee updateEmployee = restTemplate.getForObject(getRootUrl() + "/employee/update/" + id, Employee.class);
        assertNotNull(updateEmployee);
    }

    @Test
    public void testCreateBuilding() {
        Employee employee = new Employee();
        employee.setName("test");
        employee.setSurname("test");
        employee.setPhone("4534364436");
        employee.setAddress("test");
        employee.setAge((short) 23);
        employee.setSalary(4224);
        employee.setPosition("rtegdf");
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/employee/addEmployee/", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
}
