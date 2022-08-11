package cnab.batch.segment.asegment;

import cnab.commonsfileds.base.GenericBasicField;

public class Purpose extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public Purpose(String field, int size) {
        super(field, size);
    }

    public Purpose(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
