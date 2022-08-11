package cnab.batch.header.fields.servico;

import cnab.commonsfileds.base.GenericBasicField;

public class LayoutVersion extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public LayoutVersion(Long field, int size) {
        super(field, size);
    }

    public LayoutVersion(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
