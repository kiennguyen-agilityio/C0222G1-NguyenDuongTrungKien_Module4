package com.codegym.model.person.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String birthday;
    private String  gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType  customerType;

    public Customer() {
    }


    public String getId() {
        return id;
    }

    public void setId(String customerId) {
        this.id = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String customerName) {
        this.name = customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String customerBirthDay) {
        this.birthday = customerBirthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String customerGender) {
        this.gender = customerGender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String customerIdCard) {
        this.idCard = customerIdCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String customerPhone) {
        this.phone = customerPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String customerEmail) {
        this.email = customerEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String customerAddress) {
        this.address = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
