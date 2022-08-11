package testFactories;

import cnab.batch.segment.csegment.CSegment;
import cnab.batch.segment.csegment.InssValue;
import cnab.batch.segment.csegment.PaymentAccountNumber;
import cnab.batch.segment.csegment.complementarydata.payment.ComplementaryPaymentData;
import cnab.commonsfileds.account.*;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class CSegmentFactory {

    private CSegmentFactory() {

    }

    public static CSegment createDefaultCSegment() throws ContentMoreThan240CharactersException {
        ComplementaryPaymentData complementaryPaymentData = ComplementaryPaymentData.createEmptyComplementaryData();

        Account substitute = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(123456L))
                .setAccountControlDigit(new AccountControlDigit(" "))
                .setBranchAccountControlDigit(new BranchAccountControlDigit(" "))
                .setBranchCode(new BranchCode(200L))
                .setBranchControlDigit(new BranchControlDigit(" "))
                .build();

        InssValue inssValue = new InssValue(new BigDecimal("0"));

        PaymentAccountNumber paymentAccountNumber = new PaymentAccountNumber(new BigInteger("12345678901234567890"));

        return CSegment.createSingleTedPayment(new BankCode(123L), complementaryPaymentData, substitute, inssValue, paymentAccountNumber);
    }
}
