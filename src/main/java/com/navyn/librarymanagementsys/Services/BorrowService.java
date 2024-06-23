package com.navyn.librarymanagementsys.Services;

import com.navyn.librarymanagementsys.Models.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> findAll();
    Borrow markStatusReturned(Long id);

    List<Borrow> findOverdue();

    Borrow save(Borrow borrow);
}