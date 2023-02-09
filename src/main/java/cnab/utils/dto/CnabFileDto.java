package cnab.utils.dto;

import java.time.LocalDate;

public record CnabFileDto(long cnpjNumber,
                          String payeeName,
                          String companyName,
                          long payeeBankcode,
                          long enrolmentType,
                          String purposeField,
                          String payementValue,
                          long enrolmentNumber,
                          LocalDate paymentDate,
                          long companyAccountNumber,
                          long beneficiaryBranchCode,
                          String remittanceInformation,
                          long beneficiaryAccountNumber,
                          String beneficiaryBranchControlDigit,
                          String beneficiaryAccountControlDigit,
                          String beneficiaryBranchAccountControlDigit) {


    public static final class CnabFileDtoBuilder {
        private long cnpjNumber;
        private String payeeName;
        private String companyName;
        private long payeeBankcode;
        private long enrolmentType;
        private String purposeField;
        private String payementValue;
        private long enrolmentNumber;
        private LocalDate paymentDate;
        private long companyAccountNumber;
        private long beneficiaryBranchCode;
        private String remittanceInformation;
        private long beneficiaryAccountNumber;
        private String beneficiaryBranchControlDigit;
        private String beneficiaryAccountControlDigit;
        private String beneficiaryBranchAccountControlDigit;

        private CnabFileDtoBuilder() {
        }

        public static CnabFileDtoBuilder aCnabFileDto() {
            return new CnabFileDtoBuilder();
        }

        public CnabFileDtoBuilder cnpjNumber(long cnpjNumber) {
            this.cnpjNumber = cnpjNumber;
            return this;
        }

        public CnabFileDtoBuilder payeeName(String payeeName) {
            this.payeeName = payeeName;
            return this;
        }

        public CnabFileDtoBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CnabFileDtoBuilder payeeBankcode(long payeeBankcode) {
            this.payeeBankcode = payeeBankcode;
            return this;
        }

        public CnabFileDtoBuilder enrolmentType(long enrolmentType) {
            this.enrolmentType = enrolmentType;
            return this;
        }

        public CnabFileDtoBuilder purposeField(String purposeField) {
            this.purposeField = purposeField;
            return this;
        }

        public CnabFileDtoBuilder payementValue(String payementValue) {
            this.payementValue = payementValue;
            return this;
        }

        public CnabFileDtoBuilder enrolmentNumber(long enrolmentNumber) {
            this.enrolmentNumber = enrolmentNumber;
            return this;
        }

        public CnabFileDtoBuilder paymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public CnabFileDtoBuilder companyAccountNumber(long companyAccountNumber) {
            this.companyAccountNumber = companyAccountNumber;
            return this;
        }

        public CnabFileDtoBuilder beneficiaryBranchCode(long beneficiaryBranchCode) {
            this.beneficiaryBranchCode = beneficiaryBranchCode;
            return this;
        }

        public CnabFileDtoBuilder remittanceInformation(String remittanceInformation) {
            this.remittanceInformation = remittanceInformation;
            return this;
        }

        public CnabFileDtoBuilder beneficiaryAccountNumber(long beneficiaryAccountNumber) {
            this.beneficiaryAccountNumber = beneficiaryAccountNumber;
            return this;
        }

        public CnabFileDtoBuilder beneficiaryBranchControlDigit(String beneficiaryBranchControlDigit) {
            this.beneficiaryBranchControlDigit = beneficiaryBranchControlDigit;
            return this;
        }

        public CnabFileDtoBuilder beneficiaryAccountControlDigit(String beneficiaryAccountControlDigit) {
            this.beneficiaryAccountControlDigit = beneficiaryAccountControlDigit;
            return this;
        }

        public CnabFileDtoBuilder beneficiaryBranchAccountControlDigit(String beneficiaryBranchAccountControlDigit) {
            this.beneficiaryBranchAccountControlDigit = beneficiaryBranchAccountControlDigit;
            return this;
        }

        public CnabFileDto build() {
            return new CnabFileDto(cnpjNumber, payeeName, companyName, payeeBankcode, enrolmentType, purposeField,
                    payementValue, enrolmentNumber, paymentDate, companyAccountNumber, beneficiaryBranchCode,
                    remittanceInformation, beneficiaryAccountNumber, beneficiaryBranchControlDigit,
                    beneficiaryAccountControlDigit, beneficiaryBranchAccountControlDigit);
        }
    }
}
