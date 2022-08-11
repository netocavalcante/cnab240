package cnab.batch.segment.csegment.complementarydata.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class OtherDeductions extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public OtherDeductions(BigDecimal field, int size) {
        super(field, size);
    }

    public OtherDeductions(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
