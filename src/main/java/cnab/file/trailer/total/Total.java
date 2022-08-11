package cnab.file.trailer.total;

import cnab.utils.Util;

public class Total {
    private final TotalOfRecords totalOfRecords;
    private final TotalOfBatchs totalOfBatchs;
    private final TotalOfAcoountsPerBatch totalOfAcoountsPerBatch;

    public Total(TotalBuilder totalBuilder) {
        this.totalOfBatchs = totalBuilder.totalOfBatchs;
        this.totalOfRecords = totalBuilder.totalOfRecords;
        this.totalOfAcoountsPerBatch = totalBuilder.totalOfAcoountsPerBatch;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(totalOfRecords)+
                Util.getValueIfExist(totalOfBatchs)+
                Util.getValueIfExist(totalOfAcoountsPerBatch);
    }

    public static final class TotalBuilder {
        private TotalOfRecords totalOfRecords;
        private TotalOfBatchs totalOfBatchs;
        private TotalOfAcoountsPerBatch totalOfAcoountsPerBatch;

        public TotalBuilder(TotalOfRecords totalOfRecords, TotalOfBatchs totalOfBatchs, TotalOfAcoountsPerBatch totalOfAcoountsPerBatch) {
            this.totalOfRecords = totalOfRecords;
            this.totalOfBatchs = totalOfBatchs;
            this.totalOfAcoountsPerBatch = totalOfAcoountsPerBatch;
        }

        public TotalBuilder setTotalOfRecords(TotalOfRecords totalOfRecords) {
            this.totalOfRecords = totalOfRecords;
            return this;
        }

        public TotalBuilder setTotalOfBatchs(TotalOfBatchs totalOfBatchs) {
            this.totalOfBatchs = totalOfBatchs;
            return this;
        }

        public TotalBuilder setTotalOfAcoountsPerBatch(TotalOfAcoountsPerBatch totalOfAcoountsPerBatch) {
            this.totalOfAcoountsPerBatch = totalOfAcoountsPerBatch;
            return this;
        }

        public Total build() {
            return new Total(this);
        }
    }
}
