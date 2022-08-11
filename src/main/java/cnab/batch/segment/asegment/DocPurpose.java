package cnab.batch.segment.asegment;

import cnab.commonsfileds.base.GenericBasicField;

public class DocPurpose extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public DocPurpose(String field, int size) {
        super(field, size);
    }

    public DocPurpose(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
