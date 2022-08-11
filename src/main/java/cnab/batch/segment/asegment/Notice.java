package cnab.batch.segment.asegment;

import cnab.commonsfileds.base.GenericBasicField;

public class Notice extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public Notice(Long field, int size) {
        super(field, size);
    }

    public Notice(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
