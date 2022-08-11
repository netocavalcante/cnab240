package cnab.batch.segment.commonsfields;

import cnab.commonsfileds.base.GenericBasicField;

public class RegistrationNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public RegistrationNumber(Long field, int size) {
        super(field, size);
    }

    public RegistrationNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
