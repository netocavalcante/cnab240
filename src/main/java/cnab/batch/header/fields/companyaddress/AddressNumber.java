package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class AddressNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 5;

    public AddressNumber(Long field, int size) {
        super(field, size);
    }

    public AddressNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
