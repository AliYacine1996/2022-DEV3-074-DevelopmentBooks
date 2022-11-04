package com.example.developmentbooks.utils;

import com.example.developmentbooks.model.ShoppingCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterUtils {
    public static Map<String, Integer> shoppingCartListToMap(List<ShoppingCart> shoppingCarts) {
        Map<String, Integer> shoppingCartMap = new HashMap<>();
        shoppingCarts.forEach(
                shoppingCart -> shoppingCartMap.put(shoppingCart.getBookId(), shoppingCart.getCount())
        );


        return shoppingCartMap;
    }
}
