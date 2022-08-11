package cnab.batch.segment.asegment.service.transaction;

import cnab.commonsfileds.base.GenericBasicField;

public final class TransactionType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public TransactionType(Long field, int size) {
        super(field, size);
    }

    public TransactionType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
