package cnab.batch.segment.csegment;

import cnab.commonsfileds.base.GenericBasicField;

import java.math.BigInteger;

public class PaymentAccountNumber extends GenericBasicField<BigInteger> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public PaymentAccountNumber(BigInteger field, int size) {
        super(field, size);
    }

    public PaymentAccountNumber(BigInteger field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
