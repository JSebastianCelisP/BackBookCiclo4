package com.library.booksS.models;

import org.springframework.data.annotation.Id;

public class BookS {
    @Id
    private int idBookS;
    private String title;
    private int units;
    private String autor;
    private String description;
    private double price;

    public BookS(int idBookS, String title, int units, String autor, String description, double price) {
        this.idBookS = idBookS;
        this.title = title;
        this.units = units;
        this.autor = autor;
        this.description = description;
        this.price = price;
    }

    public int getIdBookS() {
        return idBookS;
    }

    public void setIdBookS(int idBookS) {
        this.idBookS = idBookS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}