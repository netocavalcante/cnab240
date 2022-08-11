package cnab.commonsfileds.account;

import cnab.commonsfileds.base.GenericBasicField;

public final class AccountNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 12;

    public AccountNumber(Long field, int size) {
        super(field, size);
    }

    public AccountNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}