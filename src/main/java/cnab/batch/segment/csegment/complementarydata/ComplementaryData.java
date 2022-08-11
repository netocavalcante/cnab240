package cnab.batch.segment.csegment.complementarydata;

import cnab.batch.segment.csegment.complementarydata.payment.ComplementaryPaymentData;
import cnab.utils.Util;

public final class ComplementaryData {
    private final ComplementaryPaymentData payment;

    public ComplementaryData(ComplementaryPaymentData payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return Util.getValueIfExist(payment);
    }
}
