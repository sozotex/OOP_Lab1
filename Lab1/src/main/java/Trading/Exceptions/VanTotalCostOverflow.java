package Trading.Exceptions;

public class VanTotalCostOverflow extends VanOverflow {
    public VanTotalCostOverflow(double allowed, double attempted) {
        super(allowed, attempted);
    }
}
