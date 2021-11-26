package com.library.booksS.models;

import org.springframework.data.annotation.Id;

public class BookS {
    @Id
    private int idBookS;
    private String title;
    private int units;
    private String author;
    private String description;
    private double price;

    public BookS(int idBookS, String title, int units, String author, String description, double price) {
        this.idBookS = idBookS;
        this.title = title;
        this.units = units;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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