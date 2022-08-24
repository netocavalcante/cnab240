package cnab.file.trailer;

import cnab.batch.Batch;
import cnab.commonsfileds.control.BankCode;
import cnab.commonsfileds.control.Control;
import cnab.commonsfileds.restricteduse.CnabRestrictedUse;
import cnab.file.trailer.total.Total;
import cnab.file.trailer.total.TotalOfAcoountsPerBatch;
import cnab.file.trailer.total.TotalOfBatchs;
import cnab.file.trailer.total.TotalOfRecords;
import cnab.service.Service;
import cnab.utils.Util;

import java.util.Collection;
import java.util.Set;

public final class FileTrailer {
    private final Total total;
    private final Control control;
    private final CnabRestrictedUse cnabRestrictedUse;
    private final CnabRestrictedUse secondCnabRestrictedUse;

    public FileTrailer(Set<Batch> batchs, BankCode bankCode) {

        this.cnabRestrictedUse = new CnabRestrictedUse(9);
        this.control = Control.createDefaultFileTrailer(bankCode);
        this.secondCnabRestrictedUse = new CnabRestrictedUse(205);

        Long totalOfBatches = (long) batchs.size();
        Long totalOfRecords = getTotalOfRecordsInBatchs(batchs, totalOfBatches);

        this.total = new Total.TotalBuilder(new TotalOfRecords(totalOfBatches), new TotalOfBatchs(totalOfRecords),
                new TotalOfAcoountsPerBatch(0L)).build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(control) +
                Util.getValueIfExist(cnabRestrictedUse) +
                Util.getValueIfExist(total) +
                Util.getValueIfExist(secondCnabRestrictedUse) ;
    }

    private long getTotalOfRecordsInBatchs(Set<Batch> batchs, Long totalOfBatches) {
        Long batchsLines = totalOfBatches * 2;
        Long headersLines = 2L;

        return batchs.stream()
                .map(Batch::getServices)
                .flatMap(Collection::stream)
                .map(Service::getAmountOfSegments)
                .reduce(headersLines+batchsLines, Long::sum);
    }

}
