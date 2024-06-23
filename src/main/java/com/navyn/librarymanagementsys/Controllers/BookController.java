package com.navyn.librarymanagementsys.Controllers;

import com.navyn.librarymanagementsys.Services.BookService;
import com.navyn.librarymanagementsys.ServiceImpls.JwtService;
import com.navyn.librarymanagementsys.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.navyn.librarymanagementsys.Models.Book;
import com.navyn.librarymanagementsys.Models.UserData;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/registration")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void addBook(@RequestBody Book book, HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        System.out.println(authHeader);
        if(authHeader != null && authHeader.startsWith("Bearer")){
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }
        UserData info=userService.loadCurrentUser(username);
        book.setCreated(username);

        bookService.addBook(book);
    }

    @GetMapping("/snoop")
    public String Snopp(){
        return "Snoop";
    }
}
