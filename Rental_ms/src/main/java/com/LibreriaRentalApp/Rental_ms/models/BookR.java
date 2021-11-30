package com.LibreriaRentalApp.Rental_ms.models;

import org.springframework.data.annotation.Id;

public class BookR {
    @Id
    private int idBookR;
    private String bookCover;
    private String title;
    private int units;
    private String author;
    private String description;

    public BookR(int idBookR, String bookCover, String title, int units, String author, String description) {
        this.idBookR = idBookR;
        this.bookCover = bookCover;
        this.title = title;
        this.units = units;
        this.author = author;
        this.description = description;
    }


    public int getIdBookR() {
        return idBookR;
    }

    public void setIdBookR(int idBookR) {
        this.idBookR = idBookR;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
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
}