package com.navyn.librarymanagementsys.Payloads.Requests;

import lombok.Data;

@Data
public class Book {
    private Long BookId;

    private String author;
    private String title;
    private String ISBN;
    private String publisher;
    private String publishedDate;
    private Integer copiesAvailable;
    private Integer copiesInStock;
    private String category;
}
