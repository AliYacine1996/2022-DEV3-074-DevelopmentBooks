package com.example.developmentbooks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookBasketTest {

    @Test
    void getBookTotalPriceFor1() {
        //GIVEN
        BookBasket bookbasket = new BookBasket();
        List<Book> books = new ArrayList<>();
        //WHEN
        books.add(new Book("Title", "Author", 2022));
        //THEN
        Assertions.assertEquals(50, bookbasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor2Different() {
        //GIVEN
        BookBasket bookbasket = new BookBasket();
        List<Book> books = new ArrayList<>();
        //WHEN
        books.add(new Book("Title", "Author", 2022));
        books.add(new Book("Title2", "Author", 2022));
        //THEN
        Assertions.assertEquals(95, bookbasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor3Differents() {
        //GIVEN
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        //WHEN
        books.add(new Book("Title", "Author", 2022));
        books.add(new Book("Title2", "Author", 2022));
        books.add(new Book("Title", "Author", 2020));

        //THEN
        Assertions.assertEquals(135, bookBasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor4Differents() {
        //GIVEN
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        //WHEN
        books.add(new Book("Title", "Author", 2022));
        books.add(new Book("Title2", "Author", 2022));
        //Same title but other year
        books.add(new Book("Title", "Author", 2020));
        //Same title but other author
        books.add(new Book("Title", "Author2", 2020));

        //THEN
        Assertions.assertEquals(160, bookBasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor5Differents() {
        //GIVEN
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        //WHEN
        books.add(new Book("Title", "Author", 2022));
        books.add(new Book("Title2", "Author", 2022));
        //Same title but other year
        books.add(new Book("Title", "Author", 2020));
        //Same title but other author
        books.add(new Book("Title", "Author2", 2020));
        //Same title but other year
        books.add(new Book("Title3", "Author2", 2019));

        //THEN
        Assertions.assertEquals(187.5, bookBasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor3DiffAnd1Duplicate() {
        //GIVEN
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        //WHEN
        books.add(new Book("Title", "Author", 2022));
        // It's a duplicate
        books.add(new Book("Title", "Author", 2022));

        books.add(new Book("Title2", "Author", 2022));
        //Same title but other year
        books.add(new Book("Title", "Author", 2020));


        //THEN
        Assertions.assertEquals(185, bookBasket.getBookTotalPrice(books));
    }

    @Test
    void getBookTotalPriceFor5DiffAnd3Duplicate() {
        //GIVEN
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        //WHEN
        books.add(new Book("Title", "Author", 2022));
        // It's a duplicate
        books.add(new Book("Title", "Author", 2022));

        books.add(new Book("Title2", "Author", 2022));
        // It's a duplicate
        books.add(new Book("Title2", "Author", 2022));

        books.add(new Book("Title3", "Author", 2020));
        // It's a duplicate
        books.add(new Book("Title3", "Author", 2020));

        books.add(new Book("Title2", "Author", 2019));

        books.add(new Book("Title3", "Author", 2018));


        //THEN
        Assertions.assertEquals(320, bookBasket.getBookTotalPrice(books));
    }
}