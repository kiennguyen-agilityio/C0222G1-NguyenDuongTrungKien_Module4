package com.codegym.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="form_register")
public class FormModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 45,message = "tên phải lớn hơn 5")
    private String firstName ;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 45,message = "họ phải lớn hơn 5")
    private String lastName;

    @NotEmpty(message = "không được để trống")
    @Pattern(regexp = "^$|[0-9]{10}", message = "độ dài là 10 và phải là số dương")
    private String numberPhone;

    @Pattern(regexp = "^$|[0-9]{2}",message = "sai format")
    @Range(min = 18, max = 100 , message = "phải là số dương ")
    private String age;

    @NotEmpty(message = "không được để trống")
    @Email
    private String email;

    public FormModel() {
    }

    public FormModel(Long id,@NotEmpty @Size(min = 5, max = 45) String firstName,
                             @NotEmpty @Size(min = 5, max = 45) String lastName,
                             @NotEmpty @Pattern(regexp = "^$|[0-9]{10}", message = "độ dài là 10 và phải là số dương") String numberPhone,
                             @Pattern(regexp = "^$|[0-9]{2}") @Range(min = 18, max = 100) String age,
                             @NotEmpty @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
