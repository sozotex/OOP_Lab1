package Items;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeSortTest {
    @Test
    public void robustaPrice() {
        CoffeeSort sort = CoffeeSort.ROBUSTA;
        int volume = (int) (500 * Math.random());

        Assertions.assertEquals(sort.price(volume), 50. * volume / 100);
        Assertions.assertEquals(sort.price(volume * 2), 50. * volume * 2 / 100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> sort.price(-volume));
    }

    @Test
    public void arabicaPrice() {
        CoffeeSort sort = CoffeeSort.ARABICA;
        int volume = (int) (500 * Math.random());

        Assertions.assertEquals(75. * volume / 100, sort.price(volume));
        Assertions.assertEquals(75. * volume * 2 / 100, sort.price(volume * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> sort.price(-volume));
    }

    @Test
    public void libericaPrice() {
        CoffeeSort sort = CoffeeSort.LIBERICA;
        int volume = (int) (500 * Math.random());

        Assertions.assertEquals(100. * volume / 100, sort.price(volume));
        Assertions.assertEquals(100. * volume * 2 / 100, sort.price(volume * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> sort.price(-volume));
    }

    @Test
    public void bourbonPrice() {
        CoffeeSort sort = CoffeeSort.BOURBON;
        int volume = (int) (500 * Math.random());

        Assertions.assertEquals(125. * volume / 100, sort.price(volume));
        Assertions.assertEquals(125. * volume * 2 / 100, sort.price(volume * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> sort.price(-volume));
    }
}
