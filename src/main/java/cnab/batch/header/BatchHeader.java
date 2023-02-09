package cnab.batch.header;

import cnab.batch.header.fields.*;
import cnab.batch.header.fields.companyaddress.CompanyAdress;
import cnab.batch.header.fields.service.BatchHeaderService;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.company.Company;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.ControlNumber;
import cnab.commonsfileds.control.RecordType;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.Util;
import cnab.utils.validator.CNABConstraintValidator;

public class BatchHeader {
    private final Control control;
    private final Company company;
    private final Occurrence occurrences;
    private final PaymentType paymentType;
    private final Information information;
    private final BatchHeaderService service;
    private final CompanyAdress companyAdress;
    private final CnabRestrictedUse firstCnabRestrictedUse;
    private final CnabRestrictedUse secondCnabRestrictedUse;

    public BatchHeader(BatchHeaderBuilder batchHeaderBuilder) {
        this.control = batchHeaderBuilder.control;
        this.service = batchHeaderBuilder.service;
        this.company = batchHeaderBuilder.company;
        this.occurrences = batchHeaderBuilder.occurrences;
        this.information = batchHeaderBuilder.information;
        this.paymentType = batchHeaderBuilder.paymentType;
        this.companyAdress = batchHeaderBuilder.companyAdress;
        this.firstCnabRestrictedUse = batchHeaderBuilder.firstCnabRestrictedUse;
        this.secondCnabRestrictedUse = batchHeaderBuilder.secondCnabRestrictedUse;
    }

    public static BatchHeader createSinglePaymentBatchHeader(BankCode bankCode, BatchHeaderService service, Company company,
                                                             String informationValue, CompanyAdress companyAdress,
                                                             String occurrencesValue) throws ContentMoreThan240CharactersException {
        PaymentType paymentType = new PaymentType(0L);
        Occurrence occurrences = new Occurrence(occurrencesValue);
        Information information = new Information(informationValue);
        CnabRestrictedUse firstCnabRestrictedUse = new CnabRestrictedUse(1);
        CnabRestrictedUse secondCnabRestrictedUse = new CnabRestrictedUse(6);
        Control control = Control.createSinglePayment(bankCode, new RecordType(1L));

        return new BatchHeaderBuilder()
                .setControl(control)
                .setService(service)
                .setFirstCnabRestrictedUse(firstCnabRestrictedUse)
                .setCompany(company)
                .setInformation(information)
                .setCompanyAdress(companyAdress)
                .setSecondCnabRestrictedUse(secondCnabRestrictedUse)
                .setOccurrences(occurrences)
                .setPaymentType(paymentType)
                .build();
    }

    public ControlNumber getControlNumber() {
        return control.getControlNumber();
    }

    public BankCode getBankCode() {
        return control.getBankCode();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control)+
                Util.getValueIfExist(service)+
                Util.getValueIfExist(firstCnabRestrictedUse)+
                Util.getValueIfExist(company)+
                Util.getValueIfExist(information)+
                Util.getValueIfExist(companyAdress)+
                Util.getValueIfExist(paymentType)+
                Util.getValueIfExist(secondCnabRestrictedUse)+
                Util.getValueIfExist(occurrences);
    }

    public static final class BatchHeaderBuilder {
        private Control control;
        private Company company;
        private Occurrence occurrences;
        private Information information;
        private PaymentType paymentType;
        private BatchHeaderService service;
        private CompanyAdress companyAdress;
        private CnabRestrictedUse firstCnabRestrictedUse;
        private CnabRestrictedUse secondCnabRestrictedUse;

        public BatchHeaderBuilder(Control control, BatchHeaderService service, Company company, Information information,
                                  CompanyAdress companyAdress, PaymentType paymentType,
                                  CnabRestrictedUse firstCnabRestrictedUse, CnabRestrictedUse secondCnabRestrictedUse,
                                  Occurrence occurrences) {
            this.control = control;
            this.service = service;
            this.company = company;
            this.information = information;
            this.occurrences = occurrences;
            this.paymentType = paymentType;
            this.companyAdress = companyAdress;
            this.firstCnabRestrictedUse = firstCnabRestrictedUse;
            this.secondCnabRestrictedUse = secondCnabRestrictedUse;
        }

        public BatchHeaderBuilder() {
        }

        public BatchHeaderBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public BatchHeaderBuilder setService(BatchHeaderService service) {
            this.service = service;
            return this;
        }

        public BatchHeaderBuilder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public BatchHeaderBuilder setInformation(Information information) {
            this.information = information;
            return this;
        }

        public BatchHeaderBuilder setCompanyAdress(CompanyAdress companyAdress) {
            this.companyAdress = companyAdress;
            return this;
        }

        public BatchHeaderBuilder setPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public BatchHeaderBuilder setFirstCnabRestrictedUse(CnabRestrictedUse firstCnabRestrictedUse) {
            this.firstCnabRestrictedUse = firstCnabRestrictedUse;
            return this;
        }

        public BatchHeaderBuilder setSecondCnabRestrictedUse(CnabRestrictedUse secondCnabRestrictedUse) {
            this.secondCnabRestrictedUse = secondCnabRestrictedUse;
            return this;
        }

        public BatchHeaderBuilder setOccurrences(Occurrence occurrences) {
            this.occurrences = occurrences;
            return this;
        }

        public BatchHeader build() throws ContentMoreThan240CharactersException {

            validateBatchHeaderBuilder(getContentAsString());

            return new BatchHeader(this);
        }

        private void validateBatchHeaderBuilder(String contentAsString) throws ContentMoreThan240CharactersException {
            CNABConstraintValidator.validateLineMaxLength(contentAsString, "Batch Header");
        }

        private String getContentAsString() {
            return Util.getValueIfExist(control) +
                    Util.getValueIfExist(service) +
                    Util.getValueIfExist(firstCnabRestrictedUse) +
                    Util.getValueIfExist(company) +
                    Util.getValueIfExist(information) +
                    Util.getValueIfExist(companyAdress) +
                    Util.getValueIfExist(paymentType) +
                    Util.getValueIfExist(secondCnabRestrictedUse) +
                    Util.getValueIfExist(occurrences);
        }
    }
}
