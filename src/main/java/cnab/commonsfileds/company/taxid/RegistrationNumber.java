package cnab.commonsfileds.company.taxid;

import cnab.commonsfileds.base.GenericBasicField;

public final class RegistrationNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 14;

    public RegistrationNumber(Long field, int size) {
        super(field, size);
    }

    public RegistrationNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
