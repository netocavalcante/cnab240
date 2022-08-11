package cnab.batch.segment.asegment;

import cnab.commonsfileds.base.GenericBasicField;

public class TedPurpose extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public TedPurpose(String field, int size) {
        super(field, size);
    }

    public TedPurpose(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
