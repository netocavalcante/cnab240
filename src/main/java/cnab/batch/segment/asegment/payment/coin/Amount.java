package cnab.batch.segment.asegment.payment.coin;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class Amount extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public Amount(BigDecimal field, int size) {
        super(field, size);
    }

    public Amount(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
