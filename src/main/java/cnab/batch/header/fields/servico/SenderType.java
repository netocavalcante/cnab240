package cnab.batch.header.fields.servico;

import cnab.commonsfileds.base.GenericBasicField;

public class SenderType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 2;

    public SenderType(Long field, int size) {
        super(field, size);
    }

    public SenderType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
