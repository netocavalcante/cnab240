package cnab.file.header.fields;

import cnab.commonsfileds.base.GenericBasicField;

public final class BankName extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 30;

    public BankName(String field, int size) {
        super(field, size);
    }

    public BankName(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}

