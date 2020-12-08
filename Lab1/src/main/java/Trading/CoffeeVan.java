package Trading;

import Trading.Exceptions.VanOverflow;
import Trading.Exceptions.VanTotalCostOverflow;
import Trading.Exceptions.VanTotalVolumeOverflow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CoffeeVan {
    private final List<SameCoffee> products;
    private final int maxVolume;
    private final double maxCost;

    public CoffeeVan(int maxVolume, double maxCost) {
        if (maxVolume < 0 || maxCost < 0) {
            throw new IllegalArgumentException("max cost and max volume values should be non-negative");
        }
        this.maxCost = maxCost;
        this.maxVolume = maxVolume;
        products = new ArrayList<>();
    }

    public CoffeeVan(int maxVolume, double maxCost, SameCoffee... products) throws VanOverflow {
        this(maxVolume, maxCost);
        this.fill(products);
    }

    public List<SameCoffee> getProducts() {
        return products;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public double getMaxCost() {
        return maxCost;
    }

    public void fill(SameCoffee... products) throws VanOverflow {
        for (var item : products) {
            addProduct(item);
        }
    }

    private void addProduct(SameCoffee sameCoffee) throws VanOverflow {
        double cost = 0;
        int volume = 0;
        for (var item : products) {
            cost += item.cost();
            volume += item.volume();
        }
        if (cost + sameCoffee.cost() > maxCost) {
            throw new VanTotalCostOverflow(maxCost, cost + sameCoffee.cost());
        }
        if (volume + sameCoffee.volume() > maxVolume) {
            throw new VanTotalVolumeOverflow(maxVolume, volume + sameCoffee.volume());
        }
        products.add(sameCoffee);
    }

    public void sortProducts() {
        var comp = new Comparator<SameCoffee>() {
            public int compare(SameCoffee lhs, SameCoffee rhs) {
                return Double.compare(lhs.cost() / lhs.volume(), rhs.cost() / rhs.volume());
            }
        };

        products.sort(comp);
    }

    public CoffeeSearcher searchItems() {
        return new CoffeeSearcher(products.toArray(new SameCoffee[0]));
    }
}
