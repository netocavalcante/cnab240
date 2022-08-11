package cnab.batch.header.fields;

import cnab.commonsfileds.base.GenericBasicField;

public class PaymentType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public PaymentType(Long field, int size) {
        super(field, size);
    }

    public PaymentType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
