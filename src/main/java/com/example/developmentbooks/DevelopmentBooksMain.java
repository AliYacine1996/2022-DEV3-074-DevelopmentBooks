package com.example.developmentbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DevelopmentBooksMain {

    public static void main(String[] args) {
        BookBasket bookBasket = new BookBasket();
        List<Book> books = new ArrayList<>();

        Scanner myScanner = new Scanner(System.in);
        // while statement the user will
        // contiue to add books to the list until they hit n or
        System.out.println("What book would you like to purchase?");
        System.out.println("What title?");
        String title = myScanner.next();

        System.out.println("What author?");
        String author = myScanner.next();

        System.out.println("What year?");
        int year = myScanner.nextInt();
        books.add(new Book(title, author, year));
        System.out.println("Would you like another book ? y or n");
        String otherBook = myScanner.next();
        while (!otherBook.equals("n")) {
            System.out.println("What book would you like to purchase?");
            System.out.println("What title?");
            title = myScanner.next();
            System.out.println("What author?");
            author = myScanner.next();
            System.out.println("What year?");
            year = myScanner.nextInt();
            books.add(new Book(title, author, year));
            System.out.println("Would you like another book ? y or n");
            otherBook = myScanner.next();
            // if statement to end while statement when n is entered
            if (otherBook.equals("n")) {
                break;
            }
        }

        System.out.println(bookBasket.getBookTotalPrice(books));

    }

}
