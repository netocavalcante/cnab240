package cnab.batch.segment.commonsfields.payee;

import cnab.commonsfileds.base.GenericBasicField;

public class CentralizedChamberCode extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 3;

    public CentralizedChamberCode(Long field, int size) {
        super(field, size);
    }

    public CentralizedChamberCode(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
