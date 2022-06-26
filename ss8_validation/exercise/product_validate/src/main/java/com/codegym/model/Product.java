package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!")
    private String name;

    @Column(columnDefinition = "double")
    private String price;

    private String description;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid firm of product!")
    private String producer;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
