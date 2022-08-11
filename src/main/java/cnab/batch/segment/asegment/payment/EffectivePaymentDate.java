package cnab.batch.segment.asegment.payment;

import cnab.commonsfileds.base.GenericBasicField;
import cnab.utils.DateTimeUtil;

import java.time.LocalDate;

public class EffectivePaymentDate extends GenericBasicField<String> {
    private static final int FIELD_SIZE_V10_9 = 8;

    public EffectivePaymentDate(LocalDate field, int size) {
        super(DateTimeUtil.dateFormat(field), size);
    }

    public EffectivePaymentDate(LocalDate field) {
        super(DateTimeUtil.dateFormat(field), FIELD_SIZE_V10_9);
    }
}
