package Items;

public class CoffeeItem {
    private final CoffeeSort sort;
    private final CoffeeState state;
    private final CoffeePackaging packaging;
    private final int volume;

    public CoffeeItem(CoffeeSort sort, CoffeeState state, CoffeePackaging packaging, int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("volume should have non-negative value");
        }

        this.sort = sort;
        this.state = state;
        this.packaging = packaging;
        this.volume = volume;
    }

    public CoffeeSort getSort() {
        return sort;
    }

    public CoffeeState getState() {
        return state;
    }

    public CoffeePackaging getPackaging() {
        return packaging;
    }

    public int getVolume() {
        return volume;
    }

    public double price() {
        return state.priceMultiplier(sort.price(volume)) + packaging.price(volume);
    }
}
