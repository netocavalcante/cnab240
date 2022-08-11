package cnab.commonsfileds.account;

import cnab.commonsfileds.base.GenericBasicField;

public final class BranchAccountControlDigit extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public BranchAccountControlDigit(String field, int size) {
        super(field, size);
    }

    public BranchAccountControlDigit(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
