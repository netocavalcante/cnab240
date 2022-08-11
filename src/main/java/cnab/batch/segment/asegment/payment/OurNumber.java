package cnab.batch.segment.asegment.payment;

import cnab.commonsfileds.base.GenericBasicField;

public class OurNumber extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public OurNumber(String field, int size) {
        super(field, size);
    }

    public OurNumber(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
