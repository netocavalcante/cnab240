package cnab.file.header.fields.file;

import cnab.commonsfileds.base.GenericBasicField;

public final class Density extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public Density(Long field, int size) {
        super(field, size);
    }

    public Density(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}