package cnab.batch.segment.asegment.service.transaction;

import cnab.commonsfileds.base.GenericBasicField;

public class TransactionCode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public TransactionCode(Long field, int size) {
        super(field, size);
    }

    public TransactionCode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
