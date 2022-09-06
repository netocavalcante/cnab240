import cnab.commonsfileds.account.AccountNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountNumberTest {

    @Test
    void ShouldLeftPaddingWithZeros_WhenTheAccountNumberIsLessThan12() {
        var value = 123456789L;
        var accountNumber = new AccountNumber(value);
        assertEquals("000123456789", accountNumber.toString());
    }

    @Test
    void ShouldChangeTheDefaultToString_WhenTheAccountNumberIsLessThan12() {
        var value = 123456789L;
        var accountNumber = new AccountNumber(value, 9);
        assertEquals("   123456789", accountNumber.toString());
    }

    @Test
    void ShouldLefPaddingWithZerosAndhangeTheDefaultToString_WhenTheAccountNumberIsLessThan12() {
        var value = 1234L;
        var accountNumber = new AccountNumber(value,9);
        assertEquals("   000001234", accountNumber.toString());
    }
}
