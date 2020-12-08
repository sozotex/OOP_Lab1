package Trading;

import Items.CoffeeItem;
import Trading.Exceptions.EmptySameCoffee;

public class SameCoffee {
    private final CoffeeItem item;
    private int number;

    public SameCoffee(CoffeeItem item, int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number should a have positive value");
        }
        this.item = item;
        this.number = number;
    }

    public CoffeeItem getItem() {
        return item;
    }

    public int getNumber() {
        return number;
    }

    public double cost() {
        return number * item.price();
    }

    public int volume() {
        return number * item.getVolume();
    }

    public void consumeItem() throws EmptySameCoffee {
        if (number > 0) {
            number--;
        } else {
            throw new EmptySameCoffee();
        }
    }
}
