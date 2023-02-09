package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class EffectivelyPaidValue extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public EffectivelyPaidValue(BigDecimal field, int size) {
        super(field, size);
    }

    public EffectivelyPaidValue(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
