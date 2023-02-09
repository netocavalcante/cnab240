package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

public class PayeeName extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 30;

    public PayeeName(String field, int size) {
        super(field, size);
    }

    public PayeeName(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
