package Items;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeStateTest {
    @Test
    public void beansPriceMultiplier() {
        CoffeeState state = CoffeeState.BEANS;
        double price = Math.random() * 1000;

        Assertions.assertEquals(price, state.priceMultiplier(price));
        Assertions.assertEquals(price * 2, state.priceMultiplier(price * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> state.priceMultiplier(-price));
    }

    @Test
    public void groundPriceMultiplier() {
        CoffeeState state = CoffeeState.GROUND;
        double price = Math.random() * 1000;

        Assertions.assertEquals(price * 1.1, state.priceMultiplier(price));
        Assertions.assertEquals(price * 2.2, state.priceMultiplier(price * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> state.priceMultiplier(-price));
    }

    @Test
    public void instantPriceMultiplier() {
        CoffeeState state = CoffeeState.INSTANT;
        double price = Math.random() * 1000;

        Assertions.assertEquals(price * 1.2, state.priceMultiplier(price));
        Assertions.assertEquals(price * 2.4, state.priceMultiplier(price * 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> state.priceMultiplier(-price));
    }
}
