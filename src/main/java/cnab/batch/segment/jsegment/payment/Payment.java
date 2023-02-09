package cnab.batch.segment.jsegment.payment;

import cnab.utils.Util;

import java.math.BigDecimal;

public class Payment {
    private final Value value;
    private final BarCode barCode;
    private final DueDate dueDate;
    private final PayeeName payeeName;
    private final CoinAmount coinAmount;
    private final Description description;
    private final PaymentDate paymentDate;
    private final AdditionValue additionValue;
    private final DeductionValue deductionValue;
    private final EffectivelyPaidValue effectivelyPaidValue;

    public Payment(PaymentBuilder paymentBuilder) {
        this.value = paymentBuilder.value;
        this.barCode = paymentBuilder.barCode;
        this.dueDate = paymentBuilder.dueDate;
        this.payeeName = paymentBuilder.payeeName;
        this.coinAmount = paymentBuilder.coinAmount;
        this.description = paymentBuilder.description;
        this.paymentDate = paymentBuilder.paymentDate;
        this.additionValue = paymentBuilder.additionValue;
        this.deductionValue = paymentBuilder.deductionValue;
        this.effectivelyPaidValue = paymentBuilder.effectivelyPaidValue;
    }

    @Override
    public String toString() {
        return Util.getValueIfExist(barCode)  +
                Util.getValueIfExist(payeeName)  +
                Util.getValueIfExist(dueDate)  +
                Util.getValueIfExist(value)  +
                Util.getValueIfExist(deductionValue)  +
                Util.getValueIfExist(additionValue)  +
                Util.getValueIfExist(paymentDate)  +
                Util.getValueIfExist(effectivelyPaidValue) +
                Util.getValueIfExist(coinAmount)  +
                Util.getValueIfExist(description);
    }

    public BigDecimal getEffectivelyPaidValue() {
        return effectivelyPaidValue.getField();
    }

    public BigDecimal getCoinAmount() {
        return coinAmount.getField();
    }

    public static final class PaymentBuilder {
        private Value value;
        private BarCode barCode;
        private DueDate dueDate;
        private PayeeName payeeName;
        private CoinAmount coinAmount;
        private Description description;
        private PaymentDate paymentDate;
        private AdditionValue additionValue;
        private DeductionValue deductionValue;
        private EffectivelyPaidValue effectivelyPaidValue;

        public PaymentBuilder() {
        }

        public PaymentBuilder(Value value, BarCode barCode, DueDate dueDate, PayeeName payeeName, CoinAmount coinAmount,
                              Description description, PaymentDate paymentDate, AdditionValue additionValue,
                              DeductionValue deductionValue, EffectivelyPaidValue effectivelyPaidValue) {
            this.value = value;
            this.barCode = barCode;
            this.dueDate = dueDate;
            this.payeeName = payeeName;
            this.coinAmount = coinAmount;
            this.description = description;
            this.paymentDate = paymentDate;
            this.additionValue = additionValue;
            this.deductionValue = deductionValue;
            this.effectivelyPaidValue = effectivelyPaidValue;
        }

        public PaymentBuilder setValue(Value value) {
            this.value = value;
            return this;
        }

        public PaymentBuilder setBarCode(BarCode barCode) {
            this.barCode = barCode;
            return this;
        }

        public PaymentBuilder setDueDate(DueDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public PaymentBuilder setPayeeName(PayeeName payeeName) {
            this.payeeName = payeeName;
            return this;
        }

        public PaymentBuilder setCoinAmount(CoinAmount coinAmount) {
            this.coinAmount = coinAmount;
            return this;
        }

        public PaymentBuilder setDescription(Description description) {
            this.description = description;
            return this;
        }

        public PaymentBuilder setPaymentDate(PaymentDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentBuilder setAdditionValue(AdditionValue additionValue) {
            this.additionValue = additionValue;
            return this;
        }

        public PaymentBuilder setDeductionValue(DeductionValue deductionValue) {
            this.deductionValue = deductionValue;
            return this;
        }

        public PaymentBuilder setEffectivelyPaidValue(EffectivelyPaidValue effectivelyPaidValue) {
            this.effectivelyPaidValue = effectivelyPaidValue;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
