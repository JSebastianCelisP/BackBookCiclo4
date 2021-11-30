package com.LibreriaRentalApp.Rental_ms.models;

import org.springframework.data.annotation.Id;

public class AccountB {
    @Id
    private int idUser;
    private String username;
    private int count;

    public AccountB(int idUser, String username, int count) {
        this.idUser = idUser;
        this.username = username;
        this.count = count;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {this.idUser = idUser;}

    public String getUsername(){ return username;}

    public void setUsername( String username){this.username = username;}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}