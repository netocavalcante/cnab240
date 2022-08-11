package cnab.batch.segment.csegment;

import cnab.batch.segment.csegment.complementarydata.ComplementaryData;
import cnab.batch.segment.csegment.complementarydata.payment.ComplementaryPaymentData;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.batch.segment.commonsfields.service.Service;
import cnab.commonsfileds.account.Account;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.RecordType;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;

import java.util.Objects;

import static cnab.utils.validator.CNABConstraintValidator.validateLineMaxLength;

public final class CSegment implements cnab.batch.segment.Segment {
    private final Account substitute;
    private final Control control;
    private final Service service;
    private final InssValue inssValue;
    private final ComplementaryData complementaryData;
    private final CnabRestrictedUse cnabFirstRestrictedUse;
    private final CnabRestrictedUse cnabSecondRestrictedUse;
    private final PaymentAccountNumber paymentAccountNumber;

    public CSegment(CSegmentBuilder cSegmentBuilder) {
        this.control = cSegmentBuilder.control;
        this.service = cSegmentBuilder.service;
        this.substitute = cSegmentBuilder.substitute;
        this.inssValue = cSegmentBuilder.inssValue;
        this.complementaryData = cSegmentBuilder.complementaryData;
        this.paymentAccountNumber = cSegmentBuilder.paymentAccountNumber;
        this.cnabFirstRestrictedUse = cSegmentBuilder.cnabFirstRestrictedUse;
        this.cnabSecondRestrictedUse = cSegmentBuilder.cnabSecondRestrictedUse;
    }

    public static CSegment createSingleTedPayment(BankCode bankCode, ComplementaryPaymentData complementaryPaymentData,
                                                  Account substitute, InssValue inssValue,
                                                  PaymentAccountNumber paymentAccountNumber) throws ContentMoreThan240CharactersException {
        Control control = Control.createTedSinglePayment(bankCode, new RecordType(3L));
        Service service = new Service(new RegistrationNumber(1L), new Segment("C"));
        ComplementaryData complementaryData = new ComplementaryData(complementaryPaymentData);
        CnabRestrictedUse cnabFirstRestrictedUse = new CnabRestrictedUse(3);
        CnabRestrictedUse cnabSecondRestrictedUse = new CnabRestrictedUse(93);
        return new CSegmentBuilder(control, service, cnabFirstRestrictedUse, cnabSecondRestrictedUse, complementaryData,
                substitute, inssValue, paymentAccountNumber).build();
    }



    @Override
    public String toString() {
        return  Util.getValueIfExist(control)+
                Util.getValueIfExist(service)+
                Util.getValueIfExist(cnabFirstRestrictedUse)+
                Util.getValueIfExist(complementaryData)+
                Util.getValueIfExist(substitute)+
                Util.getValueIfExist(inssValue)+
                Util.getValueIfExist(paymentAccountNumber)+
                Util.getValueIfExist(cnabSecondRestrictedUse);
    }

    @Override
    public Long getRegistrationNumber(){
        RegistrationNumber registrationNumber = this.service.getRegistrationNumber();
        return Objects.nonNull(registrationNumber) ? registrationNumber.getField() : 0;
    }

    public static final class CSegmentBuilder {
        private Account substitute;
        private Control control;
        private Service service;
        private InssValue inssValue;
        private ComplementaryData complementaryData;
        private CnabRestrictedUse cnabFirstRestrictedUse;
        private CnabRestrictedUse cnabSecondRestrictedUse;
        private PaymentAccountNumber paymentAccountNumber;

        public CSegmentBuilder(Control control, Service service, CnabRestrictedUse cnabFirstRestrictedUse,
                               CnabRestrictedUse cnabSecondRestrictedUse, ComplementaryData complementaryData,
                               Account replace, InssValue inssValue, PaymentAccountNumber paymentAccountNumber) {
            this.control = control;
            this.service = service;
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
            this.cnabSecondRestrictedUse = cnabSecondRestrictedUse;
            this.complementaryData = complementaryData;
            this.substitute = replace;
            this.inssValue = inssValue;
            this.paymentAccountNumber = paymentAccountNumber;
        }

        public CSegmentBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public CSegmentBuilder setService(Service service) {
            this.service = service;
            return this;
        }

        public CSegmentBuilder setCnabFirstRestrictedUse(CnabRestrictedUse cnabFirstRestrictedUse) {
            this.cnabFirstRestrictedUse = cnabFirstRestrictedUse;
            return this;
        }

        public CSegmentBuilder setCnabSecondRestrictedUse(CnabRestrictedUse cnabSecondRestrictedUse) {
            this.cnabSecondRestrictedUse = cnabSecondRestrictedUse;
            return this;
        }

        public CSegmentBuilder setComplementaryData(ComplementaryData complementaryData) {
            this.complementaryData = complementaryData;
            return this;
        }

        public CSegmentBuilder setSubstitute(Account substitute) {
            this.substitute = substitute;
            return this;
        }

        public CSegmentBuilder setInssValue(InssValue inssValue) {
            this.inssValue = inssValue;
            return this;
        }

        public CSegmentBuilder setPaymentAccountNumber(PaymentAccountNumber paymentAccountNumber) {
            this.paymentAccountNumber = paymentAccountNumber;
            return this;
        }

        public CSegment build() throws ContentMoreThan240CharactersException {

            validate(getContentAsString());
            return new CSegment(this);
        }

        private void validate(String contentAsString) throws ContentMoreThan240CharactersException {
            validateLineMaxLength(contentAsString, "CSegment");
        }

        private String getContentAsString() {
            return  Util.getValueIfExist(control)+
                    Util.getValueIfExist(service)+
                    Util.getValueIfExist(cnabFirstRestrictedUse)+
                    Util.getValueIfExist(complementaryData)+
                    Util.getValueIfExist(substitute)+
                    Util.getValueIfExist(inssValue)+
                    Util.getValueIfExist(paymentAccountNumber)+
                    Util.getValueIfExist(cnabSecondRestrictedUse);
        }
    }
}
