package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.FruitUnavailableException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        Catalog catalog = new Catalog();

        catalog.setPrice("Apples", 4.00);

        double priceOfApples = catalog.getPriceOf("Apples");

        assertThat(priceOfApples).isEqualTo(4.00);
    }

    @Test
    public void shouldListProductsInAlphabeticalOrder() {
        Catalog catalog = new Catalog();

        catalog.setPrice("Cherries", 3.00);
        catalog.setPrice("Apples", 4.00);
        catalog.setPrice("Bananas", 2.00);

        assertThat(catalog.getProducts()).containsExactly("Apples", "Bananas", "Cherries");
    }

    @Test(expected = FruitUnavailableException.class)
    public void shouldThrowExceptionIfFruitNotAvailable() {
        Catalog catalog = new Catalog();

        catalog.setPrice("Cherries", 3.00);
        catalog.setPrice("Apples", 4.00);
        catalog.setPrice("Bananas", 2.00);

        catalog.getPriceOf("Pears");
    }
}

