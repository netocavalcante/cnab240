package cnab.batch.segment.asegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class PaymentValue extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public PaymentValue(BigDecimal field, int size) {
        super(field, size);
    }

    public PaymentValue(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
