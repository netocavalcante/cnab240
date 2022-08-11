package cnab.batch.header.fields.servico;

import cnab.commonsfileds.base.GenericBasicField;

public class Operation extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 1;

    public Operation(String field, int size) {
        super(field, size);
    }

    public Operation(String field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
