package Items;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CoffeeItemTest {
    @Test
    public void arabicaGroundJarCreation() {
        var sort = CoffeeSort.ARABICA;
        var state = CoffeeState.GROUND;
        var packaging = CoffeePackaging.JAR;
        int volume = 400;

        var item = new CoffeeItem(sort, state, packaging, volume);

        Assertions.assertEquals(sort, item.getSort());
        Assertions.assertEquals(state, item.getState());
        Assertions.assertEquals(packaging, item.getPackaging());
        Assertions.assertEquals(volume, item.getVolume());
        Assertions.assertEquals(354, item.price());
    }

    @Test
    public void robustaBeansBagsCreation() {
        var sort = CoffeeSort.ROBUSTA;
        var state = CoffeeState.BEANS;
        var packaging = CoffeePackaging.STICKS;
        int volume = 10;

        var item = new CoffeeItem(sort, state, packaging, volume);

        Assertions.assertEquals(sort, item.getSort());
        Assertions.assertEquals(state, item.getState());
        Assertions.assertEquals(packaging, item.getPackaging());
        Assertions.assertEquals(volume, item.getVolume());
        Assertions.assertEquals(10, item.price());
    }

    @Test
    public void bourbonInstantJarCreation() {
        var sort = CoffeeSort.BOURBON;
        var state = CoffeeState.INSTANT;
        var packaging = CoffeePackaging.JAR;
        int volume = 350;

        var item = new CoffeeItem(sort, state, packaging, volume);

        Assertions.assertEquals(sort, item.getSort());
        Assertions.assertEquals(state, item.getState());
        Assertions.assertEquals(packaging, item.getPackaging());
        Assertions.assertEquals(volume, item.getVolume());
        Assertions.assertEquals(548.5, item.price());
    }

    @Test
    public void negativeVolume() {
        var sort = CoffeeSort.BOURBON;
        var state = CoffeeState.INSTANT;
        var packaging = CoffeePackaging.JAR;
        int volume = -100;

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoffeeItem(sort, state, packaging, volume));
    }
}