package cnab.file.trailer.total;

import cnab.commonsfileds.base.GenericBasicField;

public class TotalOfBatchs extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public TotalOfBatchs(Long field, int size) {
        super(field, size);
    }

    public TotalOfBatchs(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }

}
