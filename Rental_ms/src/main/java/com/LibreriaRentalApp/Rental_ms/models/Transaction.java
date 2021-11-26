package com.LibreriaRentalApp.Rental_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private int id;
    private int idUser;
    private int idBookR;
    private String nameBookR;
    private double value;
    private int count;
    private Date date;

    public Transaction(int id, int idUser, int idBookR, String nameBookR, int time, double value, int count, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.idBookR = idBookR;
        this.nameBookR = nameBookR;
        this.value = value;
        this.count = count;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBookR() {
        return idBookR;
    }

    public void setIdBookR(int idBookR) {
        this.idBookR = idBookR;
    }
    public String getnameBookR() {
        return nameBookR;
    }

    public void setnameBookR(String nameBookR) {
        this.nameBookR = nameBookR;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
