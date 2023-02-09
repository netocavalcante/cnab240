package cnab.batch.trailer;

import cnab.batch.trailer.total.Total;
import cnab.batch.trailer.total.TotalOfCoin;
import cnab.batch.trailer.total.TotalOfRecord;
import cnab.batch.trailer.total.TotalOfValue;
import cnab.commonsfileds.Occurrence;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.control.ControlNumber;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.service.PaymentService;
import cnab.service.Service;
import cnab.utils.Util;

import java.math.BigDecimal;
import java.util.Set;

public final class BatchTrailer {
    private final Total total;
    private final Control control;
    private final Occurrence occurrences;
    private final DebitNoticeNumber debitNoticeNumber;
    private final CnabRestrictedUse firstCnabRestrictedUse;
    private final CnabRestrictedUse secondCnabRestrictedUse;

    public BatchTrailer(Set<Service> segments, BankCode bankCode, ControlNumber controlNumber) {
        Long lineOfBatchHeaderAndTrailer = 2L;
        Long records = getCountOfServicesLines(segments) + lineOfBatchHeaderAndTrailer ;

        PaymentDTO paymentDTO = segments.stream().map(this::getCoinAndAmount)
                .findFirst()
                .orElse(new PaymentDTO(BigDecimal.ZERO, BigDecimal.ZERO));

        this.total = new Total.TotalBuilder()
                .setTotalOfRecord(new TotalOfRecord(records))
                .setSumOfCoin(new TotalOfCoin(paymentDTO.getCoins()))
                .setSumOfDebit(new TotalOfValue(paymentDTO.getAmount()))
                .build();

        this.firstCnabRestrictedUse = new CnabRestrictedUse(9);
        this.secondCnabRestrictedUse = new CnabRestrictedUse(165);
        this.control = Control.createDefaultBatchTrailer(bankCode, controlNumber);
        this.occurrences = new Occurrence("");
        this.debitNoticeNumber = new DebitNoticeNumber(0L);
    }

    private Long getCountOfServicesLines(Set<Service> segments) {
        return segments.stream()
                .map(Service::getAmountOfSegments)
                .findFirst()
                .get();
    }

    private PaymentDTO getCoinAndAmount(Service service) {
        return service instanceof PaymentService paymentService ?
               new PaymentDTO(paymentService.getPaymentAmount(), paymentService.getTotalOfCoin()) : null;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control)+
                Util.getValueIfExist(firstCnabRestrictedUse)+
                Util.getValueIfExist(total)+
                Util.getValueIfExist(debitNoticeNumber)+
                Util.getValueIfExist(secondCnabRestrictedUse)+
                Util.getValueIfExist(occurrences);
    }

    private static class PaymentDTO {
        BigDecimal amount;
        BigDecimal coins;

        public PaymentDTO(BigDecimal amount, BigDecimal coins) {
            this.amount = amount;
            this.coins = coins;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public BigDecimal getCoins() {
            return coins;
        }
    }
}
