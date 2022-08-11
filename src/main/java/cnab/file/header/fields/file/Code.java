package cnab.file.header.fields.file;

import cnab.commonsfileds.base.GenericBasicField;

public final class Code extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public Code(Long field, int size) {
        super(field, size);
    }

    public Code(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}


