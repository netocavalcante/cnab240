package cnab.file.header.fields;

import cnab.commonsfileds.base.GenericBasicField;

public final class BankSpecificUse extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public BankSpecificUse(String field, int size) {
        super(field, size);
    }

    public BankSpecificUse(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}