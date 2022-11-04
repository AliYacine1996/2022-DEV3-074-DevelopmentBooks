package com.example.developmentbooks.controller;


import com.example.developmentbooks.model.Book;
import com.example.developmentbooks.model.ShoppingCart;
import com.example.developmentbooks.utils.BookUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/books")
public class BookController {
    private final BookUtils bookUtils ;

    public BookController() {
        this.bookUtils = new BookUtils();
    }
    @GetMapping
    public List<Book> getBooks() {
        return bookUtils.getBooks();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/calculateTotal")
    public Double calculateTotal(@RequestBody List<ShoppingCart> shoppingCart ) {
       return bookUtils.getBookTotalPrice(shoppingCart);
    }


}
