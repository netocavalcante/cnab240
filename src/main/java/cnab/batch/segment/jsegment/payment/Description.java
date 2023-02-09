package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

public class Description extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public Description(String field, int size) {
        super(field, size);
    }

    public Description(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
