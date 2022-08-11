package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class Cep extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public Cep(Long field, int size) {
        super(field, size);
    }

    public Cep(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
