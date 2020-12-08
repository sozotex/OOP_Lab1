package Trading;

import Items.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeSearcherTest {
    SameCoffee[] sameCoffees;
    CoffeeSearcher searcher;

    @Before
    public void init() {
        sameCoffees = new SameCoffee[]{
                // 461 / 350 = 1.32
                new SameCoffee(new CoffeeItem(CoffeeSort.BOURBON, CoffeeState.BEANS, CoffeePackaging.JAR, 350), 30),
                // 11 / 10 = 1.1
                new SameCoffee(new CoffeeItem(CoffeeSort.ROBUSTA, CoffeeState.INSTANT, CoffeePackaging.STICKS, 10), 250),
                // 354 / 400 = 0.885
                new SameCoffee(new CoffeeItem(CoffeeSort.ARABICA, CoffeeState.GROUND, CoffeePackaging.JAR, 400), 10),
                // 13.4 / 7 = 1.91
                new SameCoffee(new CoffeeItem(CoffeeSort.LIBERICA, CoffeeState.INSTANT, CoffeePackaging.STICKS, 7), 300),
                // 13.25 / 10 = 1.33
                new SameCoffee(new CoffeeItem(CoffeeSort.ARABICA, CoffeeState.GROUND, CoffeePackaging.STICKS, 10), 500)
        };

        searcher = new CoffeeSearcher(sameCoffees);
    }

    @Test
    public void sortSearchArabica() {
        var result = searcher.filterBySort(CoffeeSort.ARABICA).get();

        Assertions.assertTrue(result.contains(sameCoffees[2].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
    }

    @Test
    public void sortSearchLiberica() {
        var result = searcher.filterBySort(CoffeeSort.LIBERICA).get();

        Assertions.assertTrue(result.contains(sameCoffees[3].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[4].getItem()));
    }

    @Test
    public void substanceSearchInstant() {
        var result = searcher.filterBySubstance(CoffeeState.INSTANT).get();

        Assertions.assertTrue(result.contains(sameCoffees[1].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[3].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[4].getItem()));
    }

    @Test
    public void substanceSearchBeans() {
        var result = searcher.filterBySubstance(CoffeeState.BEANS).get();

        Assertions.assertTrue(result.contains(sameCoffees[0].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[4].getItem()));
    }

    @Test
    public void packagingSearchJar() {
        var result = searcher.filterByPackaging(CoffeePackaging.JAR).get();

        Assertions.assertTrue(result.contains(sameCoffees[0].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[2].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[4].getItem()));
    }

    @Test
    public void packagingSearchBags() {
        var result = searcher.filterByPackaging(CoffeePackaging.STICKS).get();

        Assertions.assertTrue(result.contains(sameCoffees[1].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[3].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
    }

    @Test
    public void priceSearch() {
        var result = searcher.filterByPrice(10., 15.).get();

        Assertions.assertTrue(result.contains(sameCoffees[1].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[3].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
    }

    @Test
    public void volumeSearch() {
        var result = searcher.filterByVolume(9, 375).get();

        Assertions.assertTrue(result.contains(sameCoffees[0].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[1].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
    }

    @Test
    public void sequentialSearch() {
        var result =
                searcher.filterByVolume(9, 375)
                        .filterByPrice(10., 15.)
                        .filterBySort(CoffeeSort.ARABICA)
                        .get();

        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
    }

    @Test
    public void sequentialSearchWithNulls() {
        var result =
                searcher.filterByPackaging(null)
                        .filterBySort(null)
                        .filterBySubstance(null)
                        .filterByVolume(null, null)
                        .filterByPrice(null, null)
                        .get();

        Assertions.assertTrue(result.contains(sameCoffees[0].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[1].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[2].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[3].getItem()));
        Assertions.assertTrue(result.contains(sameCoffees[4].getItem()));
    }

    @Test
    public void emptyResult() {
        var result =
                searcher.filterByPrice(Double.POSITIVE_INFINITY, null).get();

        Assertions.assertFalse(result.contains(sameCoffees[0].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[1].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[2].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[3].getItem()));
        Assertions.assertFalse(result.contains(sameCoffees[4].getItem()));
    }
}