package Trading.Exceptions;

public class VanTotalVolumeOverflow extends VanOverflow {
    public VanTotalVolumeOverflow (int allowed, int attempted) {
        super(allowed, attempted);
    }
}
