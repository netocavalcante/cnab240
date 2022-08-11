package cnab.batch.segment.commonsfields;

import cnab.commonsfileds.base.GenericBasicField;

public class Segment extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public Segment(String field, int size) {
        super(field, size);
    }

    public Segment(String field) {
        super(field,FIELD_SIZE_V10_9);
    }
}
