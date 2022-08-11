package cnab.commonsfileds.control;

import cnab.commonsfileds.base.GenericBasicField;

public final class BankCode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public BankCode(Long field, int size) {
        super(field, size);
    }

    public BankCode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}

