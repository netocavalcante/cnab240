package cnab.batch.header.fields.companyaddress;

import cnab.commonsfileds.base.GenericBasicField;

public final class State extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public State(String field, int size) {
        super(field, size);
    }

    public State(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
