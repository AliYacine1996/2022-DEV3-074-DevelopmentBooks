package com.example.developmentbooks;


import java.util.List;
import java.util.Map;

public class BookBasket {

    private static final int BOOK_PRICE = 50;

    private Map<Integer, Double> discountRates =  Map.of(1, 0.0, 2, 0.05, 3, 0.1, 4, 0.2, 5, 0.25);



    public double getBookTotalPrice(List<Book> books){
        int quantity = books.size();
        return BOOK_PRICE*quantity - this.discountRates.get(quantity)*BOOK_PRICE;
    }

}
