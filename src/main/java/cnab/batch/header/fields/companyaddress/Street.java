package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class Street extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 30;

    public Street(String field, int size) {
        super(field, size);
    }

    public Street(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
