package cnab.batch.header.fields;

import cnab.commonsfileds.base.GenericBasicField;

public class Information extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 40;

    public Information(String field, int size) {
        super(field, size);
    }

    public Information(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
