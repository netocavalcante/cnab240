package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class AddicionalInfo extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 15;

    public AddicionalInfo(String field, int size) {
        super(field, size);
    }

    public AddicionalInfo(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
