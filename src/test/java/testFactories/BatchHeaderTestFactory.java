package testFactories;

import cnab.batch.header.BatchHeader;
import cnab.batch.header.fields.companyaddress.CompanyAdress;
import cnab.batch.header.fields.servico.BatchHeaderService;
import cnab.commonsfileds.Name;
import cnab.commonsfileds.account.*;
import cnab.commonsfileds.company.AgreementNumber;
import cnab.commonsfileds.company.Company;
import cnab.commonsfileds.company.taxid.Registration;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;

import static cnab.batch.header.fields.companyaddress.CompanyAdress.createDefaultCompanyAddressAsBlank;

public final class BatchHeaderTestFactory {
    private BatchHeaderTestFactory() {
    }

    public static BatchHeader createDefaultBatchHeader() throws ContentMoreThan240CharactersException {
        BankCode bankCode = new BankCode(123L);
        BatchHeaderService service = BatchHeaderService.createDefaultBathHeaderService(98L,3L);

        Account account = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(19106001L))
                .setAccountControlDigit(new AccountControlDigit(" "))
                .setBranchAccountControlDigit(new BranchAccountControlDigit(" "))
                .setBranchCode(new BranchCode(1L))
                .setBranchControlDigit(new BranchControlDigit(" "))
                .build();

        Company company = new Company.CompanyBuilder()
                .setRegistration(Registration.createRegistration(2L, 7063698000133L))
                .setName(new Name("ARVAL BRASIL LTDA"))
                .setAgreementNumber(new AgreementNumber("00000000000019106001"))
                .setAccount(account)
                .build();

        CompanyAdress companyAdress = createDefaultCompanyAddressAsBlank();


        return BatchHeader.createSinglePaymentBatchHeader(bankCode,
                service, company, " ", companyAdress, " ");
    }

    public static BatchHeader createInvalidBatchHeaderWithInvalidName() throws ContentMoreThan240CharactersException {
        BankCode bankCode = new BankCode(123L);
        BatchHeaderService service = BatchHeaderService.createDefaultBathHeaderService(98L,3L);

        Account account = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(19106001L))
                .setAccountControlDigit(new AccountControlDigit(" "))
                .setBranchAccountControlDigit(new BranchAccountControlDigit(" "))
                .setBranchCode(new BranchCode(1L))
                .setBranchControlDigit(new BranchControlDigit(" "))
                .build();

        Company company = new Company.CompanyBuilder()
                .setRegistration(Registration.createRegistration(2L, 7063698000133L))
                .setName(new Name("ARVAL BRASIL LTDA", 100))
                .setAgreementNumber(new AgreementNumber("00000000000019106001"))
                .setAccount(account)
                .build();

        CompanyAdress companyAdress = createDefaultCompanyAddressAsBlank();


        return BatchHeader.createSinglePaymentBatchHeader(bankCode,
                service, company, " ", companyAdress, " ");
    }
}
