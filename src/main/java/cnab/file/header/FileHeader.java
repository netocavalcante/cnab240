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
    private final File fileData;
    private final Control control;
    private final BankName bankName;
    private final Company organization;
    private final BankSpecificUse bankPurpose;
    private final CnabRestrictedUse firstCnabRestricUse;
    private final CnabRestrictedUse thirdCnabRestricUse;
    private final CnabRestrictedUse secondCnabRestricUse;
    private final CompanySpecificUse organizationPurpose;

    private FileHeader(FileHeaderBuilder fileHeaderBuilder) {
        this.control = fileHeaderBuilder.control;
        this.bankName = fileHeaderBuilder.bankName;
        this.fileData = fileHeaderBuilder.fileData;
        this.bankPurpose = fileHeaderBuilder.bankPurpose;
        this.organization = fileHeaderBuilder.organization;
        this.firstCnabRestricUse = fileHeaderBuilder.firstCnabRestricUse;
        this.thirdCnabRestricUse = fileHeaderBuilder.thirdCnabRestricUse;
        this.organizationPurpose = fileHeaderBuilder.organizationPurpose;
        this.secondCnabRestricUse = fileHeaderBuilder.secondCnabRestricUse;
    }

    public static FileHeader createDefaultFileHeader(long bankCode, String bankNameDescription, Company company) throws ContentMoreThan240CharactersException {

        File file = createDefaultSinglePaymentFile();
        BankName bankName = new BankName(bankNameDescription);
        BankSpecificUse bankSpecificUse = new BankSpecificUse("");
        CnabRestrictedUse firstRestrictedUse = new CnabRestrictedUse(9);
        CnabRestrictedUse thirdCnabRestricUse = new CnabRestrictedUse(29);
        CnabRestrictedUse secondCnabRestricUse = new CnabRestrictedUse(10);
        CompanySpecificUse companySpecificUse = new CompanySpecificUse("");
        Control defaultFileHeaderControl = Control.createDefaultFileHeader(new BankCode(bankCode));

        return new FileHeader.FileHeaderBuilder(defaultFileHeaderControl,firstRestrictedUse, secondCnabRestricUse,
                thirdCnabRestricUse, company, bankName, file,bankSpecificUse,companySpecificUse).build();
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
        private  File fileData;
        private  Control control;
        private  BankName bankName;
        private  Company organization;
        private  BankSpecificUse bankPurpose;
        private  CnabRestrictedUse firstCnabRestricUse;
        private  CnabRestrictedUse thirdCnabRestricUse;
        private  CnabRestrictedUse secondCnabRestricUse;
        private  CompanySpecificUse organizationPurpose;

        public FileHeaderBuilder() {
        }

        public FileHeaderBuilder(Control control, CnabRestrictedUse firstCnabRestricUse,
                                 CnabRestrictedUse secondCnabRestricUse, CnabRestrictedUse thirdCnabRestricUse,
                                 Company organization, BankName bankName, File fileData, BankSpecificUse bankPurpose,
                                 CompanySpecificUse organizationPurpose) {
            this.control = control;
            this.fileData = fileData;
            this.bankName = bankName;
            this.bankPurpose = bankPurpose;
            this.organization = organization;
            this.thirdCnabRestricUse = thirdCnabRestricUse;
            this.firstCnabRestricUse = firstCnabRestricUse;
            this.organizationPurpose = organizationPurpose;
            this.secondCnabRestricUse = secondCnabRestricUse;
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
