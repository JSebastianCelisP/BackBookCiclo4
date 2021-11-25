package com.LibreriaRentalApp.Rental_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private int id;
    private int idUser;
    private int idBookR;
    private int time;
    private double value;
    private Date date;

    public Transaction(int id, int idUser, int idBookR, int time, double value, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.idBookR = idBookR;
        this.time = time;
        this.value = value;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
