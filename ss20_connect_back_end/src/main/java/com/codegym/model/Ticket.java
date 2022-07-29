package com.codegym.model;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    private int id ;
    private  int price;
    private   String startPosition;
    private  String  endPosition;
    private  String  startDate;
    private   String  time;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;
    private int amount;

    public Ticket() {
    }

    public Ticket(int id, int price, String startPosition, String endPosition, String startDate, String time, Garage garage, int amount) {
        this.id = id;
        this.price = price;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.startDate = startDate;
        this.time = time;
        this.garage = garage;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
