package Items;

public enum CoffeeState {
    BEANS, GROUND, INSTANT;

    public double priceMultiplier(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price should have non-negative value");
        }
        return switch (this) {
            case BEANS -> price;
            case GROUND -> price * 1.1;
            case INSTANT -> price * 1.2;
        };
    }
}
