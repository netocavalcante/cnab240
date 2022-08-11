package cnab.batch.segment.bsegment;

import cnab.batch.segment.bsegment.complementarydata.ComplementaryData;
import cnab.batch.segment.bsegment.payeeenrollment.PayeeEnrollment;
import cnab.batch.segment.commonsfields.RegistrationNumber;
import cnab.batch.segment.commonsfields.Segment;
import cnab.batch.segment.commonsfields.service.Service;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.RecordType;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;

import java.util.Objects;

import static cnab.utils.validator.CNABConstraintValidator.validateLineMaxLength;

public final class BSegment implements cnab.batch.segment.Segment {
    private final Control control;
    private final Service service;
    private final ISPBCode ispbCode;
    private final SIAPECode siapeCode;
    private final PayeeEnrollment payeeEnrollment;
    private final ComplementaryData complementaryData;
    private final PayeeIdentification payeeIdentification;

    public BSegment(BSegmentBuilder bSegmentBuilder) {
        this.control = bSegmentBuilder.control;
        this.service = bSegmentBuilder.service;
        this.ispbCode = bSegmentBuilder.ispbCode;
        this.siapeCode = bSegmentBuilder.siapeCode;
        this.payeeEnrollment = bSegmentBuilder.payeeEnrollment;
        this.complementaryData = bSegmentBuilder.complementaryData;
        this.payeeIdentification = bSegmentBuilder.payeeIdentification;
    }

    public static BSegment createSingleTedPayment(BankCode bankCode, PayeeIdentification payeeIdentification,
                                                  PayeeEnrollment payeeEnrollment, ComplementaryData complementaryData,
                                                  SIAPECode siapeCode, ISPBCode ispbCode) throws ContentMoreThan240CharactersException {
        Control control = Control.createTedSinglePayment(bankCode, new RecordType(3L));
        Service service = new Service(new RegistrationNumber(2L), new Segment("B"));

        return new BSegmentBuilder(control, service, payeeIdentification, payeeEnrollment, complementaryData, siapeCode,
                ispbCode).build();
    }
    @Override
    public Long getRegistrationNumber(){
        RegistrationNumber registrationNumber = this.service.getRegistrationNumber();
        return Objects.nonNull(registrationNumber) ? registrationNumber.getField() : 0;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control) +
                Util.getValueIfExist(service) +
                Util.getValueIfExist(payeeIdentification) +
                Util.getValueIfExist(payeeEnrollment) +
                Util.getValueIfExist(complementaryData) +
                Util.getValueIfExist(siapeCode) +
                Util.getValueIfExist(ispbCode);
    }

    public static final class BSegmentBuilder {
        private Control control;
        private Service service;
        private ISPBCode ispbCode;
        private SIAPECode siapeCode;
        private PayeeEnrollment payeeEnrollment;
        private ComplementaryData complementaryData;
        private PayeeIdentification payeeIdentification;

        public BSegmentBuilder(Control control, Service service, PayeeIdentification favoredIdentification,
                               PayeeEnrollment payeeInscription, ComplementaryData complementaryData,
                               SIAPECode siapeCode, ISPBCode ispbCode) {
            this.control = control;
            this.service = service;
            this.ispbCode = ispbCode;
            this.siapeCode = siapeCode;
            this.payeeEnrollment = payeeInscription;
            this.complementaryData = complementaryData;
            this.payeeIdentification = favoredIdentification;
        }

        public BSegmentBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public BSegmentBuilder setService(Service service) {
            this.service = service;
            return this;
        }

        public BSegmentBuilder setFavoredIdentification(PayeeIdentification favoredIdentification) {
            this.payeeIdentification = favoredIdentification;
            return this;
        }

        public BSegmentBuilder setPayeeEnrollment(PayeeEnrollment payeeEnrollment) {
            this.payeeEnrollment = payeeEnrollment;
            return this;
        }

        public BSegmentBuilder setComplementaryData(ComplementaryData complementaryData) {
            this.complementaryData = complementaryData;
            return this;
        }

        public BSegmentBuilder setSiapeCode(SIAPECode siapeCode) {
            this.siapeCode = siapeCode;
            return this;
        }

        public BSegmentBuilder setIspbCode(ISPBCode ispbCode) {
            this.ispbCode = ispbCode;
            return this;
        }

        public BSegment build() throws ContentMoreThan240CharactersException {
            validate(getContentAsString());

            return new BSegment(this);
        }

        private void validate(String contentAsString) throws ContentMoreThan240CharactersException {
            validateLineMaxLength(contentAsString, "BSegment");
        }

        private String getContentAsString() {
            return  Util.getValueIfExist(control) +
                    Util.getValueIfExist(service) +
                    Util.getValueIfExist(payeeIdentification) +
                    Util.getValueIfExist(payeeEnrollment) +
                    Util.getValueIfExist(complementaryData) +
                    Util.getValueIfExist(siapeCode) +
                    Util.getValueIfExist(ispbCode);
        }

    }
}
