package cnab.batch.segment.asegment.payment.coin;

import cnab.utils.Util;

import java.math.BigDecimal;

public class CurrentCoin {
    private final Type type;
    private final Amount amount;

    public CurrentCoin(Type type, Amount amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(type) + Util.getValueIfExist(amount);
    }

    public BigDecimal getTotalOfCoin() {
        return amount.getField();
    }
}
