package cnab.commonsfileds;

import cnab.commonsfileds.base.GenericBasicField;

public class Occurrence extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 10;

    public Occurrence(String field, int size) {
        super(field, size);
    }

    public Occurrence(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
