package cnab.batch.segment.asegment;

import cnab.commonsfileds.base.GenericBasicField;

public class Information2 extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 40;

    public Information2(String field, int size) {
        super(field, size);
    }

    public Information2(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
