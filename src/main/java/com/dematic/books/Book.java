package com.dematic.books;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="Books")
public class Book {

    public Book(Long barcode, String title, String author, String genre, String date, BigDecimal price, Long quantity) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public Book() {
    }

    @Id
    @Column(name = "barcode")
    private Long barcode;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Long quantity;
}
