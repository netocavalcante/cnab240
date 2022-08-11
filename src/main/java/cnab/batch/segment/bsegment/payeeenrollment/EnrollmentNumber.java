package cnab.batch.segment.bsegment.payeeenrollment;

import cnab.commonsfileds.base.GenericBasicField;

public class EnrollmentNumber extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 14;

    public EnrollmentNumber(Long field, int size) {
        super(field, size);
    }

    public EnrollmentNumber(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
