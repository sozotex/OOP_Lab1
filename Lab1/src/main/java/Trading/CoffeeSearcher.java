package Trading;

import Items.*;

import java.util.LinkedList;
import java.util.List;

public class CoffeeSearcher {
    private List<CoffeeItem> items;

    public CoffeeSearcher(SameCoffee... sameCoffees) {
        items = new LinkedList<>();
        for (var sameCoffee : sameCoffees) {
            items.add(sameCoffee.getItem());
        }
    }

    public CoffeeSearcher filterBySort(CoffeeSort sort) {
        if (sort != null) {
            int i = 0;
            while (i < items.size()) {
                if (sort.equals(items.get(i).getSort())) {
                    i++;
                } else {
                    items.remove(i);
                }
            }
        }
        return this;
    }

    public CoffeeSearcher filterBySubstance(CoffeeState substance) {
        if (substance != null) {
            int i = 0;
            while (i < items.size()) {
                if (substance.equals(items.get(i).getState())) {
                    i++;
                } else {
                    items.remove(i);
                }
            }
        }
        return this;
    }

    public CoffeeSearcher filterByPackaging(CoffeePackaging packaging) {
        if (packaging != null) {
            int i = 0;
            while (i < items.size()) {
                if (packaging.equals(items.get(i).getPackaging())) {
                    i++;
                } else {
                    items.remove(i);
                }
            }
        }
        return this;
    }

    public CoffeeSearcher filterByPrice(Double min, Double max) {
        int i = 0;
        while (i < items.size()) {
            double price = items.get(i).price();
            if (price > (min == null ? Double.NEGATIVE_INFINITY : min) &&
                    price < (max == null ? Double.POSITIVE_INFINITY : max)
            ) {
                i++;
            } else {
                items.remove(i);
            }
        }

        return this;
    }

    public CoffeeSearcher filterByVolume(Integer min, Integer max) {
        int i = 0;
        while (i < items.size()) {
            int volume = items.get(i).getVolume();
            if (volume > (min == null ? Double.NEGATIVE_INFINITY : min) &&
                    volume < (max == null ? Double.POSITIVE_INFINITY : max)
            ) {
                i++;
            } else {
                items.remove(i);
            }
        }

        return this;
    }

    public List<CoffeeItem> get() {
        return items;
    }
}
