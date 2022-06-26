package com.codegym.model.person.employee;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer divisionId) {
        this.id = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String divisionName) {
        this.name = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
