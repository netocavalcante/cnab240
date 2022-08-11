package cnab.batch.trailer.total;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class TotalOfCoin extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 18;

    public TotalOfCoin(BigDecimal field, int size) {
        super(field, size);
    }

    public TotalOfCoin(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
