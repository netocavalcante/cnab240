package cnab.batch.trailer.total;

import cnab.utils.Util;

public final class Total {
    private final TotalOfCoin sumOfCoin;
    private final TotalOfValue sumOfDebit;
    private final TotalOfRecord totalOfRecord;

    public Total(TotalBuilder totalBuilder) {
        this.sumOfCoin = totalBuilder.sumOfCoin;
        this.sumOfDebit = totalBuilder.sumOfDebit;
        this.totalOfRecord = totalBuilder.totalOfRecord;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(totalOfRecord)+
                Util.getValueIfExist(sumOfDebit)+
                Util.getValueIfExist(sumOfCoin);
    }

    public static final class TotalBuilder {
        private TotalOfCoin sumOfCoin;
        private TotalOfValue sumOfDebit;
        private TotalOfRecord totalOfRecord;

        public TotalBuilder() {
        }

        public TotalBuilder(TotalOfRecord totalOfRecords, TotalOfValue sumOfDebits, TotalOfCoin sumOfCoins) {
            this.sumOfCoin = sumOfCoins;
            this.sumOfDebit = sumOfDebits;
            this.totalOfRecord = totalOfRecords;
        }

        public TotalBuilder setTotalOfRecord(TotalOfRecord totalOfRecord) {
            this.totalOfRecord = totalOfRecord;
            return this;
        }

        public TotalBuilder setSumOfDebit(TotalOfValue sumOfDebit) {
            this.sumOfDebit = sumOfDebit;
            return this;
        }

        public TotalBuilder setSumOfCoin(TotalOfCoin sumOfCoin) {
            this.sumOfCoin = sumOfCoin;
            return this;
        }

        public Total build() {
            return new Total(this);
        }
    }
}
