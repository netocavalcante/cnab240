package cnab.batch.segment.jsegment.payment;

import cnab.commonsfileds.base.GenericBasicField;
import cnab.utils.DateTimeUtil;

import java.time.LocalDate;

public class PaymentDate extends GenericBasicField<String> {
private static final int FIELD_SIZE_V10_9 = 8;

public PaymentDate(LocalDate field, int size) {
        super(DateTimeUtil.dateFormat(field), size);
        }

public PaymentDate(LocalDate field) {
        super(DateTimeUtil.dateFormat(field), FIELD_SIZE_V10_9);
        }

 }
