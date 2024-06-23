package com.navyn.librarymanagementsys.Payloads.Requests;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private Long BorrowId;
    private Long BookId;
    private Long UserId;
    private Date BorrowDate;
    private Date ReturnDate;
    private String BorrowStatus;
}
