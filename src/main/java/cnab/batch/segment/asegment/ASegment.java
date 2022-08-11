package cnab.batch.segment.asegment;

import cnab.batch.segment.Segment;
import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.payee.Payee;
import cnab.batch.segment.asegment.payment.Payment;
import cnab.batch.segment.asegment.service.Aservice;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.RecordType;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;
import cnab.utils.validator.CNABConstraintValidator;

import java.math.BigDecimal;
import java.util.Objects;

public final class ASegment implements Segment {
    private final Notice notice;
    private final Payee receiver;
    private final Purpose purpose;
    private final Control control;
    private final Payment payment;
    private final Aservice service;
    private final DocPurpose docPurpose;
    private final TedPurpose tedPurpose;
    private final Occurrence occurrences;
    private final Information2 information2;
    private final CnabRestrictedUse cnabFirstRestrictedUse;

    public ASegment(ASegmentBuilder aSegmentBuilder) {
        this.notice = aSegmentBuilder.notice;
        this.purpose = aSegmentBuilder.purpose;
        this.payment = aSegmentBuilder.payment;
        this.control = aSegmentBuilder.control;
        this.service = aSegmentBuilder.service;
        this.receiver = aSegmentBuilder.receiver;
        this.docPurpose = aSegmentBuilder.docPurpose;
        this.tedPurpose = aSegmentBuilder.tedPurpose;
        this.occurrences = aSegmentBuilder.occurrences;
        this.information2 = aSegmentBuilder.information2;
        this.cnabFirstRestrictedUse = aSegmentBuilder.cnabFirstRestrictedUse;
    }

    public static ASegment createSingleTedPayment(BankCode bankCode, Transaction transaction, Payee payee,
                                                  Payment payment, Information2 information2, DocPurpose docPurpose,
                                                  TedPurpose tedPurpose, Purpose purpose, Notice notice,
                                                  Occurrence occurrence) throws ContentMoreThan240CharactersException {
        Control control = Control.createTedSinglePayment(bankCode, new RecordType(3L));
        Aservice aservice = new Aservice(new RegistrationNumber(1L), transaction);
        CnabRestrictedUse firstCnabRestrictedUse = new CnabRestrictedUse(3);

        return new ASegmentBuilder(control, aservice, firstCnabRestrictedUse, payee, payment, information2, docPurpose,
                tedPurpose, purpose, notice, occurrence)
                .build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control)  +
                Util.getValueIfExist(service)  +
                Util.getValueIfExist(receiver)  +
                Util.getValueIfExist(payment)  +
                Util.getValueIfExist(information2)  +
                Util.getValueIfExist(docPurpose)  +
                Util.getValueIfExist(tedPurpose)  +
                Util.getValueIfExist(purpose)  +
                Util.getValueIfExist(cnabFirstRestrictedUse)  +
                Util.getValueIfExist(notice)  +
                Util.getValueIfExist(occurrences);
    }

    public BankCode getBankCode() {
        return control.getBankCode();
    }

    @Override
    public Long getRegistrationNumber() {
        RegistrationNumber registrationNumber = this.service.getRegistrationNumber();
        return Objects.nonNull(registrationNumber) ? registrationNumber.getField() : 0;
    }

    public BigDecimal getTotalOfCoin() {
        return payment.getTotalOfCoin();
    }

    public BigDecimal getPaymentAmount() {
        return payment.getPaymentAmount();
    }

    public static final class ASegmentBuilder {
        private final Notice notice;
        private final Payee receiver;
        private final Purpose purpose;
        private final Control control;
        private final Payment payment;
        private final Aservice service;
        private final DocPurpose docPurpose;
        private final TedPurpose tedPurpose;
        private final Occurrence occurrences;
        private final Information2 information2;
        private final CnabRestrictedUse cnabFirstRestrictedUse;

        public ASegmentBuilder(Control control, Aservice service, CnabRestrictedUse cnabFirstRestrictedUse,
                               Payee receiver, Payment payment, Information2 information2, DocPurpose docPurpose,
                               TedPurpose tedPurpose, Purpose purpose, Notice notice, Occurrence occurrences) {
            this.control = control;
            this.service = service;
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
            this.receiver = receiver;
            this.payment = payment;
            this.information2 = information2;
            this.docPurpose = docPurpose;
            this.tedPurpose = tedPurpose;
            this.purpose = purpose;
            this.notice = notice;
            this.occurrences = occurrences;
        }

        public ASegment build() throws ContentMoreThan240CharactersException {
            validate(getContetAsString());
            return new ASegment(this);
        }

        private void validate(String contet) throws ContentMoreThan240CharactersException {
            CNABConstraintValidator.validateLineMaxLength(contet, "ASegment");
        }

        private String getContetAsString() {
           return Util.getValueIfExist(control)  +
                    Util.getValueIfExist(service)  +
                    Util.getValueIfExist(receiver)  +
                    Util.getValueIfExist(payment)  +
                    Util.getValueIfExist(information2)  +
                    Util.getValueIfExist(docPurpose)  +
                    Util.getValueIfExist(tedPurpose)  +
                    Util.getValueIfExist(purpose)  +
                    Util.getValueIfExist(cnabFirstRestrictedUse)  +
                    Util.getValueIfExist(notice)  +
                    Util.getValueIfExist(occurrences);
        }

    }
}
