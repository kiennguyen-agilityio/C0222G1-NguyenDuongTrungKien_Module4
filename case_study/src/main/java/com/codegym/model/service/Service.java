package com.codegym.model.service;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "INT")
    private String serviceArea;
    @Column(columnDefinition = "DOUBLE")
    private String serviceCost;
    @Column(columnDefinition = "INT")
    private String serviceMaxPeople;
    private String serviceStandardRoom;
    private String descriptionOtherConvenience;
    @Column(columnDefinition = "DOUBLE")
    private String servicePoolArea;
    @Column(columnDefinition = "INT")
    private String serviceNumberOfFloors;

    @ManyToOne()
    @JoinColumn(name="rent_type_id ", nullable=false)
    private RentType rentType;

    @ManyToOne()
    @JoinColumn(name="service_type_id", nullable=false)
    private ServiceType serviceType;

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

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(String servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public String getServiceNumberOfFloors() {
        return serviceNumberOfFloors;
    }

    public void setServiceNumberOfFloors(String serviceNumberOfFloors) {
        this.serviceNumberOfFloors = serviceNumberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceArea='" + serviceArea + '\'' +
                ", serviceCost='" + serviceCost + '\'' +
                ", serviceMaxPeople='" + serviceMaxPeople + '\'' +
                ", serviceStandardRoom='" + serviceStandardRoom + '\'' +
                ", descriptionOtherConvenience='" + descriptionOtherConvenience + '\'' +
                ", servicePoolArea='" + servicePoolArea + '\'' +
                ", serviceNumberOfFloors='" + serviceNumberOfFloors + '\'' +
                ", rentType=" + rentType +
                ", serviceType=" + serviceType +
                '}';
    }
}
