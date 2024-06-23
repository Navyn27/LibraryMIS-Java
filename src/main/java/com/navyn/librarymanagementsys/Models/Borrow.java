package com.navyn.librarymanagementsys.Models;

import com.navyn.librarymanagementsys.Enums.BorrowStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowId;

    //A book may be borrowed more than once because it has multiple copies
    @ManyToOne
    private Book book;

    //A user can borrow multiple books, association between books and users is many to one
    @ManyToOne
    private UserData user;
    private Date borrowDate;
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    private BorrowStatus borrowStatus;
}
