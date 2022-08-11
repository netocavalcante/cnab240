package cnab.file.trailer.total;

import cnab.commonsfileds.base.GenericBasicField;

public final class TotalOfAcoountsPerBatch extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public TotalOfAcoountsPerBatch(Long field, int size) {
        super(field, size);
    }

    public TotalOfAcoountsPerBatch(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }

}
