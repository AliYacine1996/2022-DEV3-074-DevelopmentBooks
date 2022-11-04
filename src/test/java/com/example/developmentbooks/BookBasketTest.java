package com.example.developmentbooks;

import com.example.developmentbooks.model.ShoppingCart;
import com.example.developmentbooks.utils.BookUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BookBasketTest {

    @Test
    void getBookTotalPriceFor1() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",1));
        //THEN
        Assertions.assertEquals(50, bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor2Different() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",1));
        shoppingCarts.add(new ShoppingCart("2",1));
        //THEN
        Assertions.assertEquals(95, bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor3Differents() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",1));
        shoppingCarts.add(new ShoppingCart("2",1));
        shoppingCarts.add(new ShoppingCart("3",1));
        //THEN
        Assertions.assertEquals(135, bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor4Differents() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",1));
        shoppingCarts.add(new ShoppingCart("2",1));
        shoppingCarts.add(new ShoppingCart("3",1));
        shoppingCarts.add(new ShoppingCart("4",1));

        //THEN
        Assertions.assertEquals(160,  bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor5Differents() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",1));
        shoppingCarts.add(new ShoppingCart("2",1));
        shoppingCarts.add(new ShoppingCart("3",1));
        shoppingCarts.add(new ShoppingCart("4",1));
        shoppingCarts.add(new ShoppingCart("5",1));

        //THEN
        Assertions.assertEquals(187.5,  bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor3DiffAnd1Duplicate() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",2));
        shoppingCarts.add(new ShoppingCart("2",1));
        shoppingCarts.add(new ShoppingCart("3",1));



        //THEN
        Assertions.assertEquals(185,  bookUtils.getBookTotalPrice(shoppingCarts));
    }

    @Test
    void getBookTotalPriceFor5DiffAnd3Duplicate() {
        //GIVEN
        BookUtils bookUtils = new BookUtils();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        //WHEN
        shoppingCarts.add(new ShoppingCart("1",2));
        shoppingCarts.add(new ShoppingCart("2",2));
        shoppingCarts.add(new ShoppingCart("3",2));
        shoppingCarts.add(new ShoppingCart("4",1));
        shoppingCarts.add(new ShoppingCart("5",1));

        //THEN
        Assertions.assertEquals(320,  bookUtils.getBookTotalPrice(shoppingCarts));
    }
}