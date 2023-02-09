package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class CoinAmount  extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public CoinAmount(BigDecimal field, int size) {
        super(field, size);
    }

    public CoinAmount(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
