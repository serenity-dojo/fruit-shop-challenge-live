package com.serenitydojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {

    private Map<String, Double> prices = new HashMap<>();

    public void setPrice(String product, double price) {
        prices.put(product, price);
    }

    public double getPriceOf(String product) {
        if (!prices.containsKey(product)) {
            throw new FruitUnavailableException("Sorry, we don't have any " + product);
        }
        return prices.get(product);
    }

    public List<String> getProducts() {
        // Return products in alphabetical order
        return prices.keySet().stream().sorted().toList();
    }
}
