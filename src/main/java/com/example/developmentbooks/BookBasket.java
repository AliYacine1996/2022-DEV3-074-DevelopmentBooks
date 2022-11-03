package com.example.developmentbooks;


import java.util.*;

public class BookBasket {

    private static final int BOOK_PRICE = 50;

    private Map<Book, Integer> booksCountMap;

    private Map<Integer, Double> discountRates =  Map.of(1, 0.0, 2, 0.05, 3, 0.1, 4, 0.2, 5, 0.25);

    private List<Integer> discountGroups;
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
    private List<Integer> getDiscountGroups(Map<Book, Integer> booksCountMap)
    {
        discountGroups = new ArrayList<>();

        while (booksCountMap.size()>0)
        {
            discountGroups.add(booksCountMap.size());
            Set<Book> toBeRemoved = new HashSet<>();
            for (Book key : booksCountMap.keySet())
            {
                if (booksCountMap.get(key)==1)
                    toBeRemoved.add(key);
                else
                    booksCountMap.put(key, booksCountMap.get(key)-1);
            }
            booksCountMap.keySet().removeAll(toBeRemoved);
        }
        return discountGroups;
    }

    private List<Integer> getOptimizedDiscountGroups(Map<Book, Integer> booksCountMap)
    {
        discountGroups = getDiscountGroups(booksCountMap);
        while (discountGroups.contains(3) && discountGroups.contains(5))
        {
            discountGroups.remove((Integer)3);
            discountGroups.remove((Integer)5);
            discountGroups.add(4);
            discountGroups.add(4);
        }
        return discountGroups;
    }
    public double getBookTotalPrice(List<Book> books){
        double totalPrice = 0;
        booksCountMap = getBooksCountMap(books);
        discountGroups = getOptimizedDiscountGroups(booksCountMap);
        for (Integer quantity : discountGroups)
        {
            double discountedGroupPrice = (BOOK_PRICE - this.discountRates.get(quantity)*BOOK_PRICE)*quantity;
            totalPrice += discountedGroupPrice;
        }
        return totalPrice;
    }

}
