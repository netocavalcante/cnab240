package testFactories;

import cnab.batch.segment.asegment.*;
import cnab.batch.segment.asegment.payment.*;
import cnab.batch.segment.asegment.payment.coin.Amount;
import cnab.batch.segment.asegment.payment.coin.CurrentCoin;
import cnab.batch.segment.asegment.payment.coin.Type;
import cnab.batch.segment.asegment.service.transaction.Transaction;
import cnab.batch.segment.asegment.service.transaction.TransactionCode;
import cnab.batch.segment.asegment.service.transaction.TransactionType;
import cnab.batch.segment.commonsfields.payee.CentralizedChamberCode;
import cnab.batch.segment.commonsfields.payee.Payee;
import cnab.batch.segment.commonsfields.payee.PayeeBankCode;
import cnab.commonsfileds.Name;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.account.*;
import cnab.commonsfileds.control.BankCode;
import cnab.exceptions.ContentMoreThan240CharactersException;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ASegmentTestFactory {

    private ASegmentTestFactory() {
    }

    public static ASegment createDefaultASegment(BankCode bankCode) throws ContentMoreThan240CharactersException {
        Transaction transaction = new Transaction(new TransactionType(0L), new TransactionCode(9L));

        Account payeeAccount = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(12345678910L))
                .setAccountControlDigit(new AccountControlDigit(" "))
                .setBranchAccountControlDigit(new BranchAccountControlDigit(" "))
                .setBranchCode(new BranchCode(200L))
                .setBranchControlDigit(new BranchControlDigit(" "))
                .build();

        Payee payee = new Payee.PayeeBuilder()
                .setName(new Name("TICKET SERVICOS SA            "))
                .setAccount(payeeAccount)
                .setPayerBankCode(new PayeeBankCode(409L))
                .setCentralClearingHouseCode(new CentralizedChamberCode(700L))
                .build();

        Payment payment = new Payment.PaymentBuilder()
                .setCoin(new CurrentCoin(new Type("BRL"), new Amount(new BigDecimal("0"))))
                .setOurNumber(new OurNumber("00000000000000000000"))
                .setYourNumber(new YourNumber("clientrefr1234567890"))
                .setPaymentDate(new PaymentDate(LocalDate.of(2022,1,7)))
                .setPaymentValue(new PaymentValue(new BigDecimal("2100.01")))
                .setEffectivePaymentAmount(new EffectivePaymentAmount(new BigDecimal("0")))
                .setEffectivePaymentDate(new EffectivePaymentDate(null))
                .build();

        Information2 information2 = new Information2("");
        DocPurpose docPurpose = new DocPurpose("01");
        TedPurpose tedPurpose = new TedPurpose("00010");
        Purpose purpose = new Purpose("CP");
        Notice notice = new Notice(0L);
        Occurrence occurrences = new Occurrence("");
        return ASegment.createSingleTedPayment(bankCode, transaction, payee, payment, information2, docPurpose,
                tedPurpose, purpose, notice, occurrences);
    }

    public static ASegment createInvalidASegmentWithNoticeWith100Characters(BankCode bankCode)
            throws ContentMoreThan240CharactersException {

        Transaction transaction = new Transaction(new TransactionType(0L), new TransactionCode(9L));

        Account payeeAccount = new Account.AccountBuilder()
                .setAccountNumber(new AccountNumber(12345678910L))
                .setAccountControlDigit(new AccountControlDigit(" "))
                .setBranchAccountControlDigit(new BranchAccountControlDigit(" "))
                .setBranchCode(new BranchCode(200L))
                .setBranchControlDigit(new BranchControlDigit(" "))
                .build();

        Payee payee = new Payee.PayeeBuilder()
                .setName(new Name("TICKET SERVICOS SA            "))
                .setAccount(payeeAccount)
                .setPayerBankCode(new PayeeBankCode(409L))
                .setCentralClearingHouseCode(new CentralizedChamberCode(700L))
                .build();

        Payment payment = new Payment.PaymentBuilder()
                .setCoin(new CurrentCoin(new Type("BRL"), new Amount(new BigDecimal("0"))))
                .setOurNumber(new OurNumber("00000000000000000000"))
                .setYourNumber(new YourNumber("clientrefr1234567890"))
                .setPaymentDate(new PaymentDate(LocalDate.of(2022,1,7)))
                .setPaymentValue(new PaymentValue(new BigDecimal("2100.01")))
                .setEffectivePaymentAmount(new EffectivePaymentAmount(new BigDecimal("0")))
                .setEffectivePaymentDate(new EffectivePaymentDate(null))
                .build();

        Information2 information2 = new Information2("");
        DocPurpose docPurpose = new DocPurpose("01");
        TedPurpose tedPurpose = new TedPurpose("00010");
        Purpose purpose = new Purpose("CP");
        Notice notice = new Notice(0L,100);
        Occurrence occurrences = new Occurrence("");
        return ASegment.createSingleTedPayment(bankCode, transaction, payee, payment, information2, docPurpose,
                tedPurpose, purpose, notice, occurrences);
    }
}
