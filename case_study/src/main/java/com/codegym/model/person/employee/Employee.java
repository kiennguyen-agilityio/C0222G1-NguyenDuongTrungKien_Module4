package com.codegym.model.person.employee;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Không để trống")
    private String name;

    @NotNull(message = "Không để trống")
    private String birthday;

    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "CMND gồm 9 hoặc 12 số")
    private String idCard;

    @Min(value = 0, message = "Tối thiểu 0")
    private double salary;

    @Pattern(regexp = "^09[0-1][0-9]{7}|\\(84\\)\\+9[0-1][0-9]{7}$",
             message = "Phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Phải đúng định dạng abc@xyz.com")
    private String email;

    @NotBlank(message = "Không để trống")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name="division_id", nullable=false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
