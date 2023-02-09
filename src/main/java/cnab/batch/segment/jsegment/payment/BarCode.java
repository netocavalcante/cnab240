package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigInteger;

public class BarCode extends GenericBasicField<BigInteger> {
    private static final int FIELD_SIZE_V10_9 = 44;

    public BarCode(BigInteger field, int size) {
        super(field, size);
    }

    public BarCode(BigInteger field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
