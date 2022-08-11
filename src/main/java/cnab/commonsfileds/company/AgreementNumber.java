package cnab.commonsfileds.company;

import cnab.commonsfileds.base.GenericBasicField;

public final class AgreementNumber extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public AgreementNumber(String field, int size) {
        super(field, size);
    }

    public AgreementNumber(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}