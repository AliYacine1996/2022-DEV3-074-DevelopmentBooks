package com.example.developmentbooks.utils;


import com.example.developmentbooks.model.Book;
import com.example.developmentbooks.model.ShoppingCart;


import java.util.*;

public class BookUtils {

    private static final int BOOK_PRICE = 50;

    private Map<Book, Integer> booksCountMap;

    private Map<Integer, Double> discountRates;

    private List<Integer> discountGroups;

    public BookUtils() {
        this.discountRates = Map.of(1, 0.0, 2, 0.05, 3, 0.1, 4, 0.2, 5, 0.25);
    }

    private Map<Book, Integer> getBooksCountMap(List<Book> books) {
        booksCountMap = new HashMap<>();
        for (Book book : books) {
            if (booksCountMap.containsKey(book)) {
                booksCountMap.put(book, booksCountMap.get(book) + 1);
            } else {
                booksCountMap.put(book, 1);
            }
        }
        return booksCountMap;


    }

    private List<Integer> getDiscountGroups(Map<String, Integer> booksCountMap) {
        discountGroups = new ArrayList<>();

        while (booksCountMap.size() > 0) {
            discountGroups.add(booksCountMap.size());
            Set<String> toBeRemoved = new HashSet<>();
            for (String key : booksCountMap.keySet()) {
                if (booksCountMap.get(key) == 1)
                    toBeRemoved.add(key);
                else
                    booksCountMap.put(key, booksCountMap.get(key) - 1);
            }
            booksCountMap.keySet().removeAll(toBeRemoved);
        }
        return discountGroups;
    }

    private List<Integer> getOptimizedDiscountGroups(Map<String, Integer> booksCountMap) {
        discountGroups = getDiscountGroups(booksCountMap);
        while (discountGroups.contains(3) && discountGroups.contains(5)) {
            discountGroups.remove((Integer) 3);
            discountGroups.remove((Integer) 5);
            discountGroups.add(4);
            discountGroups.add(4);
        }
        return discountGroups;
    }


    /**
     * method who return the totalPrice with discount
     *
     * @param booksCountMap the list of books the customer wants to buy
     * @return totalPrice it's the price with discount
     */
    public double getBookTotalPrice(List<ShoppingCart>booksCountMap) {
        double totalPrice = 0;

        discountGroups = getOptimizedDiscountGroups(ConverterUtils.shoppingCartListToMap(booksCountMap));
        for (Integer quantity : discountGroups) {
            double discountedGroupPrice = (BOOK_PRICE - this.discountRates.get(quantity) * BOOK_PRICE) * quantity;
            totalPrice += discountedGroupPrice;
        }
        return totalPrice;
    }
    public List<Book> getBooks(){
        List<Book>books= new ArrayList<>();
        books.add(new Book(1L,"Clean Architecture", "Robert Martin", "2017",50,"https://raw.githubusercontent.com/stephane-genicot/katas/master/images/Kata_DevelopmentBooks_CleanArchitecture.jpeg"));
        books.add(new Book(2L,"Clean Code", "Robert Martin", "2008",50,"https://raw.githubusercontent.com/stephane-genicot/katas/master/images/Kata_DevelopmentBooks_CleanCode.png"));
        books.add(new Book(3L,"The Clean Coder", "Robert Martin", "2011",50,"https://raw.githubusercontent.com/stephane-genicot/katas/master/images/Kata_DevelopmentBooks_CleanCoder.png"));
        books.add(new Book(4L,"Working Effectively With Legacy Code", "Michael C. Feathers", "2004",50,"https://raw.githubusercontent.com/stephane-genicot/katas/master/images/Kata_DevelopmentBooks_TDD.jpeg"));
        books.add(new Book(5L,"Test Driven Development", "Kent Beck", "2003",50,"https://raw.githubusercontent.com/stephane-genicot/katas/master/images/Kata_DevelopmentBooks_Refactoring.jpeg"));
        return books;
    }

}
