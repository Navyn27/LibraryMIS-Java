package com.navyn.librarymanagementsys.Services;

import com.navyn.librarymanagementsys.Models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);
    List<Book> findAll();
    Book save(Book book);
    Boolean availableInLibrary(Long id);
    Boolean existById(Long id);
    Book updateBook(Long id, Book book);
    void delete(Long id);
    void addBook(Book book);
}