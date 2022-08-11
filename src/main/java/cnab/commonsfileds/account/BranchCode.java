package cnab.commonsfileds.account;

import cnab.commonsfileds.base.GenericBasicField;

public final class BranchCode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public BranchCode(Long field, int size) {
        super(field, size);
    }

    public BranchCode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
