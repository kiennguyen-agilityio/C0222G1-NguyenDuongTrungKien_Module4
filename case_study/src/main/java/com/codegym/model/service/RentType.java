package com.codegym.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference("rentType")
    private Set<Service> services;

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }



    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
