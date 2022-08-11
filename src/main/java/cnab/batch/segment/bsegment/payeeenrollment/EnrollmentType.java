package cnab.batch.segment.bsegment.payeeenrollment;

import cnab.commonsfileds.base.GenericBasicField;

public class EnrollmentType extends GenericBasicField<Long> {
    private static final int FIELD_SIZE_V10_9 = 1;
    public EnrollmentType(Long field, int size) {
        super(field, size);
    }

    public EnrollmentType(Long field) {
        super(field, FIELD_SIZE_V10_9);
    }
}
