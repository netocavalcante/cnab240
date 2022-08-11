package cnab.batch.segment.asegment.service.transaction;

import cnab.utils.Util;

public class Transaction {
    private final TransactionType transactionType;
    private final TransactionCode transactionCode;

    public Transaction(TransactionType transactionType, TransactionCode transactionCode) {
        this.transactionType = transactionType;
        this.transactionCode = transactionCode;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(transactionType) +
                Util.getValueIfExist(transactionCode);
    }
}
