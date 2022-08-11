package cnab.file.header;

import cnab.commonsfileds.company.Company;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.file.header.fields.BankName;
import cnab.file.header.fields.BankSpecificUse;
import cnab.file.header.fields.CompanySpecificUse;
import cnab.file.header.fields.file.File;
import cnab.utils.Util;
import cnab.utils.validator.CNABConstraintValidator;

import static cnab.file.header.fields.file.File.createDefaultSinglePaymentFile;

public final class FileHeader {
    private final Control control;
    private final CnabRestrictedUse firstCnabRestricUse;
    private final CnabRestrictedUse secondCnabRestricUse;
    private final CnabRestrictedUse thirdCnabRestricUse;
    private final Company organization;
    private final BankName bankName;
    private final File fileData;
    private final BankSpecificUse bankPurpose;
    private final CompanySpecificUse organizationPurpose;

    private FileHeader(FileHeaderBuilder fileHeaderBuilder) {
        this.control = fileHeaderBuilder.control;
        this.firstCnabRestricUse = fileHeaderBuilder.firstCnabRestricUse;
        this.secondCnabRestricUse = fileHeaderBuilder.secondCnabRestricUse;
        this.thirdCnabRestricUse = fileHeaderBuilder.thirdCnabRestricUse;
        this.organization = fileHeaderBuilder.organization;
        this.bankName = fileHeaderBuilder.bankName;
        this.fileData = fileHeaderBuilder.fileData;
        this.bankPurpose = fileHeaderBuilder.bankPurpose;
        this.organizationPurpose = fileHeaderBuilder.organizationPurpose;
    }

    public static FileHeader createDefaultFileHeader(long bankCode, String bankNameDescription, Company company) throws ContentMoreThan240CharactersException {
        Control defaultFileHeaderControl = Control.createDefaultFileHeader(new BankCode(bankCode));
        BankName bankName = new BankName(bankNameDescription);
        CnabRestrictedUse firstRestrictedUse = new CnabRestrictedUse(9);
        CnabRestrictedUse secondCnabRestricUse = new CnabRestrictedUse(10);
        CnabRestrictedUse thirdCnabRestricUse = new CnabRestrictedUse(29);
        File file = createDefaultSinglePaymentFile();
        BankSpecificUse bankSpecificUse = new BankSpecificUse("");
        CompanySpecificUse companySpecificUse = new CompanySpecificUse("");
        return new FileHeader.FileHeaderBuilder(defaultFileHeaderControl,firstRestrictedUse, secondCnabRestricUse, thirdCnabRestricUse,
                company, bankName, file,bankSpecificUse,companySpecificUse).build();
    }

    public BankCode getBankCode() {
        return this.control.getBankCode();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control) +
                Util.getValueIfExist(firstCnabRestricUse) +
                Util.getValueIfExist(organization) +
                Util.getValueIfExist(bankName) +
                Util.getValueIfExist(secondCnabRestricUse) +
                Util.getValueIfExist(fileData) +
                Util.getValueIfExist(bankPurpose) +
                Util.getValueIfExist(organizationPurpose) +
                Util.getValueIfExist(thirdCnabRestricUse);
    }

    public static final class FileHeaderBuilder {
        private  Control control;
        private  CnabRestrictedUse firstCnabRestricUse;
        private  CnabRestrictedUse secondCnabRestricUse;
        private  CnabRestrictedUse thirdCnabRestricUse;
        private  Company organization;
        private  BankName bankName;
        private  File fileData;
        private  BankSpecificUse bankPurpose;
        private  CompanySpecificUse organizationPurpose;

        public FileHeaderBuilder() {
        }

        public FileHeaderBuilder(Control control, CnabRestrictedUse firstCnabRestricUse,
                                 CnabRestrictedUse secondCnabRestricUse, CnabRestrictedUse thirdCnabRestricUse,
                                 Company organization, BankName bankName, File fileData, BankSpecificUse bankPurpose,
                                 CompanySpecificUse organizationPurpose) {
            this.control = control;
            this.firstCnabRestricUse = firstCnabRestricUse;
            this.secondCnabRestricUse = secondCnabRestricUse;
            this.thirdCnabRestricUse = thirdCnabRestricUse;
            this.organization = organization;
            this.bankName = bankName;
            this.fileData = fileData;
            this.bankPurpose = bankPurpose;
            this.organizationPurpose = organizationPurpose;
        }

        public FileHeaderBuilder setControl(Control control) {
            this.control = control;
            return this;
        }

        public FileHeaderBuilder setFirstCnabRestricUse(CnabRestrictedUse firstCnabRestricUse) {
            this.firstCnabRestricUse = firstCnabRestricUse;
            return this;
        }

        public FileHeaderBuilder setSecondCnabRestricUse(CnabRestrictedUse secondCnabRestricUse) {
            this.secondCnabRestricUse = secondCnabRestricUse;
            return this;
        }

        public FileHeaderBuilder setThirdCnabRestricUse(CnabRestrictedUse thirdCnabRestricUse) {
            this.thirdCnabRestricUse = thirdCnabRestricUse;
            return this;
        }

        public FileHeaderBuilder setOrganization(Company organization) {
            this.organization = organization;
            return this;
        }

        public FileHeaderBuilder setBankName(BankName bankName) {
            this.bankName = bankName;
            return this;
        }

        public FileHeaderBuilder setFileData(File fileData) {
            this.fileData = fileData;
            return this;
        }

        public FileHeaderBuilder setBankPurpose(BankSpecificUse bankPurpose) {
            this.bankPurpose = bankPurpose;
            return this;
        }

        public FileHeaderBuilder setOrganizationPurpose(CompanySpecificUse organizationPurpose) {
            this.organizationPurpose = organizationPurpose;
            return this;
        }

        public FileHeader build() throws ContentMoreThan240CharactersException {
            validateFileHeaderBuilder(getFileHeaderContentAsString());
            return new FileHeader(this);
        }

        private String getFileHeaderContentAsString() {
            return Util.getValueIfExist(control) +
                    Util.getValueIfExist(firstCnabRestricUse) +
                    Util.getValueIfExist(organization) +
                    Util.getValueIfExist(bankName) +
                    Util.getValueIfExist(secondCnabRestricUse) +
                    Util.getValueIfExist(fileData) +
                    Util.getValueIfExist(bankPurpose) +
                    Util.getValueIfExist(organizationPurpose) +
                    Util.getValueIfExist(thirdCnabRestricUse);
        }

        private void validateFileHeaderBuilder(String fileHeaderContent) throws ContentMoreThan240CharactersException {
            CNABConstraintValidator.validateLineMaxLength(fileHeaderContent, "File Header");
        }
    }
}
