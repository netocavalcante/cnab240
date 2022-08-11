package cnab.batch.segment.asegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class EffectivePaymentAmount extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public EffectivePaymentAmount(BigDecimal field, int size) {
        super(field, size);
    }

    public EffectivePaymentAmount(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
