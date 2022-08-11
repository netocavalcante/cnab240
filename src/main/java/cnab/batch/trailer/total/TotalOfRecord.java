package cnab.batch.trailer.total;

import cnab.commonsfileds.base.GenericBasicField;

public final class TotalOfRecord extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public TotalOfRecord(Long field, int size) {
        super(field, size);
    }

    public TotalOfRecord(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
