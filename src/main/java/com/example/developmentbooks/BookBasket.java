package com.example.developmentbooks;


import java.util.*;

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
        int quantity = 0;
        int totalPrice=0;
        booksCountMap=getBooksCountMap(books);
        while (booksCountMap.size()>0)
        {
            Set<Book> toBeRemoved = new HashSet<>();
            for (Book key : booksCountMap.keySet())
            {
                if (booksCountMap.get(key)==1)
                    toBeRemoved.add(key);
                else
                    booksCountMap.put(key, booksCountMap.get(key)-1);
            }
            quantity += toBeRemoved.size();
            totalPrice+=BOOK_PRICE*quantity - (this.discountRates.get(quantity)*(BOOK_PRICE*quantity));
            booksCountMap.keySet().removeAll(toBeRemoved);
        }
        return totalPrice;
    }

}
