package cnab.batch.segment.csegment.complementarydata.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class OtherAdditions extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public OtherAdditions(BigDecimal field, int size) {
        super(field, size);
    }

    public OtherAdditions(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
