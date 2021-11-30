package com.library.booksS.models;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Transaction {
    @Id
    private int id;
    private int idUser;
    private int idBookS;
    private String nameBookS;
    private double value;
    private Date date;
    private int count;

    public Transaction(int id, int idUser, int idBookS, String nameBookS, double value, Date date, int count) {
        this.id = id;
        this.idUser = idUser;
        this.idBookS = idBookS;
        this.nameBookS = nameBookS;
        this.value = value;
        this.date = date;
        this.count = count;
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

    public int getIdBookS() {
        return idBookS;
    }

    public void setIdBookS(int idBookS) {
        this.idBookS = idBookS;
    }

    public String getNameBookS() {
        return nameBookS;
    }

    public void setNameBookS(String nameBookS) {
        this.nameBookS = nameBookS;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
