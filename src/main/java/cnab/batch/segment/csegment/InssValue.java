package cnab.batch.segment.csegment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class InssValue extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public InssValue(BigDecimal field, int size) {
        super(field, size);
    }

    public InssValue(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
