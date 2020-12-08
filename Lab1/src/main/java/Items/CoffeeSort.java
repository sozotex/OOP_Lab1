package Items;

public enum CoffeeSort {
    ROBUSTA, ARABICA , LIBERICA, BOURBON;

    public double price (int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("volume should have a non-negative value");
        }
        return switch (this) {
            case ROBUSTA -> 50. * volume / 100;
            case ARABICA -> 75. * volume / 100;
            case LIBERICA -> 100. * volume / 100;
            case BOURBON -> 125. * volume / 100;
        };
    }
}
