package cnab.batch.segment.asegment;

import cnab.batch.segment.Segment;
import cnab.batch.segment.SegmentBuilder;
import cnab.batch.segment.asegment.payment.Payment;
import cnab.batch.segment.asegment.service.PrimaryService;
import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.payee.Payee;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.RecordType;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;

import java.math.BigDecimal;

public final class ASegment implements Segment {
    private final Notice notice;
    private final Payee receiver;
    private final Purpose purpose;
    private final Control control;
    private final Payment payment;
    private final DocPurpose docPurpose;
    private final TedPurpose tedPurpose;
    private final PrimaryService service;
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

        CnabRestrictedUse firstCnabRestrictedUse = new CnabRestrictedUse(3);

        PrimaryService primaryservice = new PrimaryService(new RegistrationNumber(1L), transaction,
                new cnab.batch.segment.commonsfields.Segment("A"));

        Control control = Control.createSinglePayment(bankCode, new RecordType(3L));

        return new ASegmentBuilder(control, primaryservice, firstCnabRestrictedUse, payee, payment, information2,
                docPurpose, tedPurpose, purpose, notice, occurrence)
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

    public BigDecimal getTotalOfCoin() {
        return payment.getTotalOfCoin();
    }

    public BigDecimal getPaymentAmount() {
        return payment.getPaymentAmount();
    }

    public static final class ASegmentBuilder implements SegmentBuilder {
        private Notice notice;
        private Payee receiver;
        private Purpose purpose;
        private Control control;
        private Payment payment;
        private DocPurpose docPurpose;
        private TedPurpose tedPurpose;
        private PrimaryService service;
        private Occurrence occurrences;
        private Information2 information2;
        private CnabRestrictedUse cnabFirstRestrictedUse;

        public ASegmentBuilder() {
        }

        public ASegmentBuilder(Control control, PrimaryService service, CnabRestrictedUse cnabFirstRestrictedUse,
                               Payee receiver, Payment payment, Information2 information2, DocPurpose docPurpose,
                               TedPurpose tedPurpose, Purpose purpose, Notice notice, Occurrence occurrences) {
            this.notice = notice;
            this.purpose = purpose;
            this.control = control;
            this.service = service;
            this.payment = payment;
            this.receiver = receiver;
            this.docPurpose = docPurpose;
            this.tedPurpose = tedPurpose;
            this.occurrences = occurrences;
            this.information2 = information2;
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
        }

        public ASegmentBuilder setNotice(Notice notice) {
            this.notice = notice;
            return this;
        }

        public ASegmentBuilder setReceiver(Payee receiver) {
            this.receiver = receiver;
            return this;
        }

        public ASegmentBuilder setPurpose(Purpose purpose) {
            this.purpose = purpose;
            return this;
        }

        public ASegmentBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public ASegmentBuilder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public ASegmentBuilder setService(PrimaryService service) {
            this.service = service;
            return this;
        }

        public ASegmentBuilder setDocPurpose(DocPurpose docPurpose) {
            this.docPurpose = docPurpose;
            return this;
        }

        public ASegmentBuilder setTedPurpose(TedPurpose tedPurpose) {
            this.tedPurpose = tedPurpose;
            return this;
        }

        public ASegmentBuilder setOccurrences(Occurrence occurrences) {
            this.occurrences = occurrences;
            return this;
        }

        public ASegmentBuilder setInformation2(Information2 information2) {
            this.information2 = information2;
            return this;
        }

        public ASegmentBuilder setCnabFirstRestrictedUse(CnabRestrictedUse cnabFirstRestrictedUse) {
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
            return this;
        }

        public ASegment build() throws ContentMoreThan240CharactersException {
            validate(getContetAsString(), ASegment.class);
            return new ASegment(this);
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
