package cnab.commonsfileds.company.taxid;

import cnab.commonsfileds.base.GenericBasicField;

public final class RegistrationType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public RegistrationType(Long field, int size) {
        super(field, size);
    }

    public RegistrationType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}


