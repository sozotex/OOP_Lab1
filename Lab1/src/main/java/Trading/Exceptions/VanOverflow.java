package Trading.Exceptions;

public class VanOverflow extends Exception {
    public VanOverflow(double allowed, double attempted) {
        super(allowed + " allowed, " + attempted + " attempted");
    }
}
