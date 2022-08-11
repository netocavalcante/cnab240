package cnab.batch.segment.bsegment;

import cnab.commonsfileds.base.GenericBasicField;

public final class ISPBCode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 8;

    public ISPBCode(Long field, int size) {
        super(field, size);
    }

    public ISPBCode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
