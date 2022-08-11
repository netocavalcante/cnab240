package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class CepAddicionalInfo extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public CepAddicionalInfo(String field, int size) {
        super(field, size);
    }

    public CepAddicionalInfo(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
