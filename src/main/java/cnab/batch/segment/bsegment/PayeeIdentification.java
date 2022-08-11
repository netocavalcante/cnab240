package cnab.batch.segment.bsegment;

import cnab.commonsfileds.base.GenericBasicField;

public class PayeeIdentification extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public PayeeIdentification(String field, int size) {
        super(field, size);
    }

    public PayeeIdentification(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
