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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static cnab.batch.header.fields.companyaddress.CompanyAdress.createDefaultCompanyAddressAsBlank;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BatchHeaderTest {
    @Test
    void shouldThrownException_WhenFileHeaderLargerThan240Characters(){

        BankCode bankCode = new BankCode(123L);
        BatchHeaderService service = BatchHeaderService.createDefaultBathHeaderService(98L,3L);

        Account account = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(3291823L))
                .setAccountControlDigit(new AccountControlDigit("2"))
                .setBranchAccountControlDigit(new BranchAccountControlDigit("2"))
                .setBranchCode(new BranchCode(123L))
                .setBranchControlDigit(new BranchControlDigit("2"))
                .build();

        Company company = new Company.CompanyBuilder()
                .setRegistration(Registration.createRegistration(2L, 1231412L))
                .setName(new Name("Company",100))
                .setAgreementNumber(new AgreementNumber("3198492"))
                .setAccount(account)
                .build();

        CompanyAdress companyAdress = createDefaultCompanyAddressAsBlank();

        ContentMoreThan240CharactersException exception = Assertions.assertThrows(
                ContentMoreThan240CharactersException.class, () -> BatchHeader.createSinglePaymentBatchHeader(bankCode,
                        service, company, " ", companyAdress, " "));

        assertThat(exception.getMessage(), containsString("The Batch Header must have less than 240 charactes"));
    }

    @Test
    void batchHeaderMustHave240Characters() throws ContentMoreThan240CharactersException {

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


        BatchHeader batchHeader = BatchHeader.createSinglePaymentBatchHeader(bankCode,
                service, company, " ", companyAdress, " ");

        assertEquals(240,batchHeader.toString().length());
    }

}
