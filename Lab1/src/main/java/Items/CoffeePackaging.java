package Items;
import java.lang.IllegalArgumentException;

public enum CoffeePackaging {
    JAR, STICKS;

    public double price(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("volume should have non-negative value");
        }
        return switch (this) {
            case STICKS -> 5;
            case JAR -> 20 + (double) volume / 100;
        };
    }
}
