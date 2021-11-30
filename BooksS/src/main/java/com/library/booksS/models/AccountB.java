package com.library.booksS.models;

import org.springframework.data.annotation.Id;

public class AccountB {
    @Id
    private int idUser;
    private String username;
    private double balance;

    public AccountB(int idUser, String username,double balance) {
        this.idUser = idUser;
        this.username = username;
        this.balance = balance;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {this.idUser = idUser;}

    public String getUsername(){ return username;}

    public void setUsername( String username){this.username = username;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

