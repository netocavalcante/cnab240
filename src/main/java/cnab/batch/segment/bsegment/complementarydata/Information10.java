package cnab.batch.segment.bsegment.complementarydata;

import cnab.commonsfileds.base.GenericBasicField;

public final class Information10 extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 35;

    public Information10(String field, int size) {
        super(field, size);
    }

    public Information10(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
