package com.cake_shop.Week7.Entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee", schema = "spring_data_jpa_example")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 1, max = 10)
    @Column(name = "name")
    private String name;

    @Size(min = 1, max = 20)
    @Column(name = "surname")
    private String surname;

    @Size(min = 10, max = 15)
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Digits(integer = 3, fraction = 0, message = "не более 3-х знаков")
    @Column(name = "age")
    private short age;

    @Column(name = "salary")
    private double salary;

    @Column(name = "position")
    private String position;



    public Employee(int id, String name, String surname, String phone, String address, short age, double salary, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}