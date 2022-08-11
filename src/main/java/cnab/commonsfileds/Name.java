package cnab.commonsfileds;

import cnab.commonsfileds.base.GenericBasicField;

public final class Name extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 30;

    public Name(String field, int size) {
        super(field, size);
    }

    public Name(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}