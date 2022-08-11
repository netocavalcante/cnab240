package cnab.commonsfileds.control;

import cnab.commonsfileds.base.GenericBasicField;

public final class RecordType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public RecordType(Long field, int size) {
        super(field, size);
    }


    public RecordType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}

