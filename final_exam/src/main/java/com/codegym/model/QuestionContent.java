package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class    Customer {
    @Id
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Phải đúng định dạng KH-XXXX")
    private String id;

    @NotBlank(message = "Không để trống")
    private String name;

    @NotNull(message = "Không để trống")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @Pattern(message = "Chỉ nhập ngày trong quá khứ")
    private String birthday;

    @NotNull (message = "Không để trống")
    private String gender;

    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "CMND gồm 9 hoặc 12 số")
    private String idCard;

    @Pattern(regexp = "^09[0-1][0-9]{7}|\\(84\\)\\+9[0-1][0-9]{7}$",
             message = "Phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",
             message = "Phải đúng định dạng abc@xyz.com")

    @NotBlank (message = "Không để trống")
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

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
