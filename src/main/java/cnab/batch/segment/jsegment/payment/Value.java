package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class Value extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public Value(BigDecimal field, int size) {
        super(field, size);
    }

    public Value(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
