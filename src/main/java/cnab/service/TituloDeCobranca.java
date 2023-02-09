package cnab.service;

import cnab.batch.segment.jsegment.JSegment;
import cnab.commonsfileds.control.BankCode;

import java.math.BigDecimal;

public final class TituloDeCobranca implements PaymentService {

    private final JSegment jSegment;

    public TituloDeCobranca (JSegment jSegment) {
        this.jSegment = jSegment;
    }

    @Override
    public BigDecimal getTotalOfCoin() {
        return this.jSegment.getTotalOfCoin();
    }

    @Override
    public BigDecimal getPaymentAmount() {
        return this.jSegment.getPaymentAmount();
    }

    @Override
    public BankCode getBankCode() {
        return this.jSegment.getbankCode();
    }

    @Override
    public long getAmountOfSegments() {
        return 1;
    }

    @Override
    public String toString() {
        return jSegment.toString();
    }

}
