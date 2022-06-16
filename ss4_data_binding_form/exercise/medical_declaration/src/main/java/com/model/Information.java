package com.model;

public class Information {
    private String name;
    private int year;
    private int month;
    private int day;
    private String gender;
    private String nationality;
    private int IdCard;
    private String travelInformation;
    private String numberVehicle;
    private String seat;
    private String startDate;
    private String endDate;
    private String place;
    private String vehicles ;
    public Information() {
    }

    public Information(String name,
                       int year,
                       int month,
                       int day,
                       String gender,
                       String nationality,
                       int idCard,
                       String travelInformation,
                       String numberVehicle,
                       String seat,
                       String startDate,
                       String endDate,
                       String place,
                       String vehicles) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
        this.nationality = nationality;
        IdCard = idCard;
        this.travelInformation = travelInformation;
        this.numberVehicle = numberVehicle;
        this.seat = seat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdCard() {
        return IdCard;
    }

    public void setIdCard(int idCard) {
        IdCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }
}
