package cnab.batch.segment.bsegment.complementarydata;

import cnab.commonsfileds.base.GenericBasicField;

public final class Information12 extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 99;

    public Information12(String field, int size) {
        super(field, size);
    }

    public Information12(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
