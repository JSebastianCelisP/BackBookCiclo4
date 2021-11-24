package com.LibreriaRentalApp.Rental_ms.models;

import org.springframework.data.annotation.Id;

public class AccountB {
    @Id
    private int idUser;
    private double balance;

    public AccountB(int idUser, double balance) {
        this.idUser = idUser;
        this.balance = balance;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

