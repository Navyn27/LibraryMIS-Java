package com.navyn.librarymanagementsys.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BookId;

    private String author;
    private String title;
    private String ISBN;
    private String publisher;
    private String publishedDate;
    private Integer copiesAvailable;
    private Integer copiesInStock;
    private String category;
    private String created;
}
