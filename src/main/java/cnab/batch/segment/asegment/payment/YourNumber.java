package cnab.batch.segment.asegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

public final class YourNumber extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public YourNumber(String field, int size) {
        super(field, size);
    }

    public YourNumber(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
