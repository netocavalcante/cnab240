package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class City extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 20;

    public City(String field, int size) {
        super(field, size);
    }

    public City(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
