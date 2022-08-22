package com.codegym.model.person.customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customerType")
    @JsonBackReference("customerType")
    private Set<Customer> customers  ;

    public CustomerType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer customerTypeId) {
        this.id = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String customerType) {
        this.name = customerType;
    }
}
