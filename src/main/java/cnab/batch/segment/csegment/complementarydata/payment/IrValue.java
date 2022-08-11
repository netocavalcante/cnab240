package cnab.batch.segment.csegment.complementarydata.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigDecimal;

public class IrValue extends GenericBasicField<BigDecimal> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public IrValue(BigDecimal field, int size) {
        super(field, size);
    }

    public IrValue(BigDecimal field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
