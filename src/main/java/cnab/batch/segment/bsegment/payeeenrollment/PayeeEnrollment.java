package cnab.batch.segment.bsegment.payeeenrollment;

import cnab.utils.Util;

public final class PayeeEnrollment {
    private final EnrollmentType type;
    private final EnrollmentNumber enrollmentNumber;

    public PayeeEnrollment(EnrollmentType type, EnrollmentNumber enrollmentNumber) {
        this.type = type;
        this.enrollmentNumber = enrollmentNumber;
    }

    @Override
    public String toString() {
        return Util.getValueIfExist(type) + Util.getValueIfExist(enrollmentNumber);
    }
}
