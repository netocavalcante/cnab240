package cnab.commonsfileds.account;


import cnab.commonsfileds.base.GenericBasicField;

public final class AccountControlDigit extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public AccountControlDigit(String field, int size) {
        super(field, size);
    }

    public AccountControlDigit(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}

