package cnab.commonsfileds.account;

import cnab.commonsfileds.base.GenericBasicField;

public final class BranchControlDigit extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public BranchControlDigit(String field, int size) {
        super(field, size);
    }

    public BranchControlDigit(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
