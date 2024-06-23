package com.navyn.librarymanagementsys.ServiceImpls;

import com.navyn.librarymanagementsys.Exceptions.ResourceNotFoundException;
import com.navyn.librarymanagementsys.Models.Book;
import com.navyn.librarymanagementsys.Repositories.BookRepository;
import com.navyn.librarymanagementsys.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is Non-Existent in the Library"));
        return Optional.ofNullable(book);
    }

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Boolean availableInLibrary(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is Non-Existent in the Library"));
        Integer copiesInStock = book.getCopiesInStock();
        Integer copiesAvailable = book.getCopiesAvailable();
        if(copiesInStock.equals(copiesAvailable)){
            return false;
        }
        return true;
    }

    @Override
    public Boolean existById(Long id){
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book is Non-Existent in the Library"));
        return true;
    }

    @Override
    public Book updateBook(Long id, Book book){
        Book savedBook = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is Non-Existent in the Library"));
        savedBook.setTitle(book.getTitle());
        savedBook.setISBN(book.getISBN());
        savedBook.setPublisher(book.getPublisher());
        savedBook.setPublishedDate(book.getPublishedDate());
        savedBook.setCopiesAvailable(book.getCopiesAvailable());
        savedBook.setCopiesInStock(book.getCopiesInStock());
        savedBook.setCategory(book.getCategory());
        bookRepository.save(savedBook);
        return savedBook;
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public void addBook(Book book){
        bookRepository.save(book);
    }
}
