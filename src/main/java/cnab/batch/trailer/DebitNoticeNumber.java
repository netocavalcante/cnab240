package cnab.batch.trailer;

import cnab.commonsfileds.base.GenericBasicField;

public class DebitNoticeNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 6;

    public DebitNoticeNumber(Long field, int size) {
        super(field, size);
    }

    public DebitNoticeNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
