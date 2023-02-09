package cnab.batch.segment.jsegment;

import cnab.batch.segment.Segment;
import cnab.batch.segment.SegmentBuilder;
import cnab.batch.segment.asegment.payment.OurNumber;
import cnab.batch.segment.asegment.service.PrimaryService;
import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.jsegment.payment.*;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.RecordType;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;

import java.math.BigDecimal;

public class JSegment implements Segment {
    private final Control control;
    private final Payment payment;
    private final CoinCode coinCode;
    private final OurNumber ourNumber;
    private final PrimaryService service;
    private final Occurrence occurrences;
    private final CnabRestrictedUse cnabFirstRestrictedUse;

    public JSegment(JSegmentBuilder jSegmentBuilder) {
        this.control = jSegmentBuilder.control;
        this.payment = jSegmentBuilder.payment;
        this.service = jSegmentBuilder.service;
        this.coinCode = jSegmentBuilder.coinCode;
        this.ourNumber = jSegmentBuilder.ourNumber;
        this.occurrences = jSegmentBuilder.occurrences;
        this.cnabFirstRestrictedUse = jSegmentBuilder.cnabFirstRestrictedUse;
    }

    public static JSegment createSinglePayment(BankCode bankCode, Transaction transaction, Value value, BarCode barCode,
                                               DueDate dueDate, PayeeName payeeName, CoinAmount coinAmount,
                                               Description description, PaymentDate paymentDate,
                                               AdditionValue additionValue, DeductionValue deductionValue,
                                               EffectivelyPaidValue effectivelyPaidValue, OurNumber ourNumber,
                                               CoinCode coinCode) throws ContentMoreThan240CharactersException {

        var control = Control.createSinglePayment(bankCode, new RecordType(3L));
        var primaryservice = new PrimaryService(new RegistrationNumber(1L), transaction,
                new cnab.batch.segment.commonsfields.Segment("J"));

        var payment = new Payment.PaymentBuilder()
                .setValue(value)
                .setBarCode(barCode)
                .setDueDate(dueDate)
                .setPayeeName(payeeName)
                .setCoinAmount(coinAmount)
                .setDescription(description)
                .setPaymentDate(paymentDate)
                .setAdditionValue(additionValue)
                .setDeductionValue(deductionValue)
                .setEffectivelyPaidValue(effectivelyPaidValue)
                .build();

        return new JSegmentBuilder()
                .setControl(control)
                .setService(primaryservice)
                .setPayment(payment)
                .setOurNumber(ourNumber)
                .setCoinCode(coinCode)
                .setCnabFirstRestrictedUse(new CnabRestrictedUse(6))
                .build();

    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control)  +
                Util.getValueIfExist(service)  +
                Util.getValueIfExist(payment)  +
                Util.getValueIfExist(ourNumber)  +
                Util.getValueIfExist(coinCode)  +
                Util.getValueIfExist(cnabFirstRestrictedUse)  +
                Util.getValueIfExist(occurrences);
    }

    public BankCode getbankCode() {
        return this.control.getBankCode();
    }

    public BigDecimal getPaymentAmount() {
        return this.payment.getEffectivelyPaidValue();
    }

    public BigDecimal getTotalOfCoin() {
        return this.payment.getCoinAmount();
    }

    public static final class JSegmentBuilder implements SegmentBuilder {
        private Control control;
        private Payment payment;
        private CoinCode coinCode;
        private OurNumber ourNumber;
        private PrimaryService service;
        private Occurrence occurrences;
        private CnabRestrictedUse cnabFirstRestrictedUse;

        public JSegmentBuilder() {
        }

        public JSegmentBuilder(Control control, Payment payment, CoinCode coinCode, OurNumber yourNumber,
                               PrimaryService service, Occurrence occurrences,
                               CnabRestrictedUse cnabFirstRestrictedUse) {
            this.control = control;
            this.payment = payment;
            this.service = service;
            this.coinCode = coinCode;
            this.ourNumber = yourNumber;
            this.occurrences = occurrences;
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
        }

        public JSegmentBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public JSegmentBuilder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public JSegmentBuilder setCoinCode(CoinCode coinCode) {
            this.coinCode = coinCode;
            return this;
        }

        public JSegmentBuilder setOurNumber(OurNumber yourNumber) {
            this.ourNumber = yourNumber;
            return this;
        }

        public JSegmentBuilder setService(PrimaryService service) {
            this.service = service;
            return this;
        }

        public JSegmentBuilder setOccurrences(Occurrence occurrences) {
            this.occurrences = occurrences;
            return this;
        }

        public JSegmentBuilder setCnabFirstRestrictedUse(CnabRestrictedUse cnabFirstRestrictedUse) {
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
            return this;
        }

        public JSegment build() throws ContentMoreThan240CharactersException {
            validate(getContetAsString(), JSegment.class);
            return new JSegment(this);
        }

        private String getContetAsString() {
            return  Util.getValueIfExist(control)  +
                    Util.getValueIfExist(service)  +
                    Util.getValueIfExist(payment)  +
                    Util.getValueIfExist(ourNumber)  +
                    Util.getValueIfExist(coinCode)  +
                    Util.getValueIfExist(cnabFirstRestrictedUse)  +
                    Util.getValueIfExist(occurrences);
        }

    }
}
