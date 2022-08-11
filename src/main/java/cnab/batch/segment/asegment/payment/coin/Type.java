package cnab.batch.segment.asegment.payment.coin;

import cnab.commonsfileds.base.GenericBasicField;

public class Type extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public Type(String field, int size) {
        super(field, size);
    }

    public Type(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
