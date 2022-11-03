package com.example.developmentbooks;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookBasket {

    private static final int BOOK_PRICE = 50;

    private Map<Book, Integer> booksCountMap;

    private Map<Integer, Double> discountRates =  Map.of(1, 0.0, 2, 0.05, 3, 0.1, 4, 0.2, 5, 0.25);

    private Map<Book, Integer> getBooksCountMap(List<Book> books){
        booksCountMap = new HashMap<>();
        for (Book book: books)
        {
            if (booksCountMap.containsKey(book))
            {
                booksCountMap.put(book, booksCountMap.get(book) + 1);
            }
            else
            {
                booksCountMap.put(book , 1);
            }
        }
        return booksCountMap;


    }


    public double getBookTotalPrice(List<Book> books){
        int quantity = books.size();
        return BOOK_PRICE*quantity - this.discountRates.get(quantity)*BOOK_PRICE;
    }

}
