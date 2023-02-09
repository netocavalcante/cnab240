package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;
import cnab.utils.DateTimeUtil;

import java.time.LocalDate;

public class DueDate extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 8;

    public DueDate(LocalDate field, int size) {
        super(DateTimeUtil.dateFormat(field), size);
    }

    public DueDate(LocalDate field) {
        super(DateTimeUtil.dateFormat(field), FIELD_SIZE_V10_9);
    }
}
