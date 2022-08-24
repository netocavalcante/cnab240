package cnab.commonsfileds.company;

import cnab.commonsfileds.Name;
import cnab.commonsfileds.account.Account;
import cnab.commonsfileds.company.taxid.Registration;
import cnab.utils.Util;

public class Company {
    private final Name name;
    private final Account account;
    private final Registration taxID;
    private final AgreementNumber agreementNumber;

    public Company(CompanyBuilder companyBuilder) {
        this.name = companyBuilder.name;
        this.account = companyBuilder.account;
        this.taxID = companyBuilder.registration;
        this.agreementNumber = companyBuilder.agreementNumber;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(taxID) +
                Util.getValueIfExist(agreementNumber) +
                Util.getValueIfExist(account) +
                Util.getValueIfExist(name);
    }

    public static final class CompanyBuilder {
        private Name name;
        private Account account;
        private Registration registration;
        private AgreementNumber agreementNumber;

        public CompanyBuilder() {
        }

        public CompanyBuilder(Registration taxID, AgreementNumber agreementNumber, Account account, Name name) {
            this.name = name;
            this.account = account;
            this.registration = taxID;
            this.agreementNumber = agreementNumber;
        }

        public CompanyBuilder setRegistration(Registration registration) {
            this.registration = registration;
            return this;
        }

        public CompanyBuilder setAgreementNumber(AgreementNumber agreementNumber) {
            this.agreementNumber = agreementNumber;
            return this;
        }

        public CompanyBuilder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public CompanyBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
