package cnab.commonsfileds.account;

import cnab.commonsfileds.base.GenericBasicField;

import static cnab.utils.Util.formatFieldToBePrinted;

public final class AccountNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 12;
    private int emptySpace;

    public AccountNumber(Long field, int size) {
        super(field, size);
        emptySpace = Math.max(FIELD_SIZE_V10_9 - size,0);
    }

    public AccountNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }

    @Override
    public String toString() {
        return formatFieldToBePrinted(getField(), getFieldSize(), emptySpace);
    }
}