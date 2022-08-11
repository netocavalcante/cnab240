import cnab.commonsfileds.Name;
import cnab.commonsfileds.account.*;
import cnab.commonsfileds.company.AgreementNumber;
import cnab.commonsfileds.company.Company;
import cnab.commonsfileds.company.taxid.Registration;
import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.file.header.FileHeader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileHeaderTest {
    @Test
    void fileHeaderMustHave240Characters() throws ContentMoreThan240CharactersException {
        Account account = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(3291823L))
                .setAccountControlDigit(new AccountControlDigit("2"))
                .setBranchAccountControlDigit(new BranchAccountControlDigit("2"))
                .setBranchCode(new BranchCode(123L))
                .setBranchControlDigit(new BranchControlDigit("2"))
                .build();

        Company company = new Company.CompanyBuilder()
                .setRegistration(Registration.createRegistration(2L, 1231412L))
                .setName(new Name("Company"))
                .setAgreementNumber(new AgreementNumber("3198492"))
                .setAccount(account)
                .build();

        FileHeader testBank = FileHeader.createDefaultFileHeader(761L, "TestBank", company);

        assertEquals(240 , testBank.toString().length());
    }

    @Test
    void shouldThrownException_WhenFileHeaderLargerThan240Characters(){
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

        ContentMoreThan240CharactersException exception = Assertions.assertThrows(ContentMoreThan240CharactersException.class,
                () -> FileHeader.createDefaultFileHeader(761L, "TestBank", company));

       assertThat(exception.getMessage(), containsString("The File Header must have less than 240 charactes"));
    }
}
