package cnab.batch.segment.bsegment;

import cnab.commonsfileds.base.GenericBasicField;

public final class SIAPECode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public SIAPECode(Long field, int size) {
        super(field, size);
    }

    public SIAPECode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
