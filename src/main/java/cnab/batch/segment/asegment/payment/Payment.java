package cnab.batch.segment.asegment.payment;

import cnab.batch.segment.asegment.payment.coin.CurrentCoin;
import cnab.utils.Util;

import java.math.BigDecimal;

public final class Payment {
    private final CurrentCoin coin;
    private final OurNumber ourNumber;
    private final YourNumber yourNumber;
    private final PaymentDate paymentDate;
    private final PaymentValue paymentValue;
    private final EffectivePaymentDate effectivePaymentDate;
    private final EffectivePaymentAmount effectivePaymentAmount;

    public Payment(PaymentBuilder paymentBuilder) {
        this.coin = paymentBuilder.coin;
        this.ourNumber = paymentBuilder.ourNumber;
        this.yourNumber = paymentBuilder.yourNumber;
        this.paymentDate = paymentBuilder.paymentDate;
        this.paymentValue = paymentBuilder.paymentValue;
        this.effectivePaymentDate = paymentBuilder.effectivePaymentDate;
        this.effectivePaymentAmount = paymentBuilder.effectivePaymentAmount;
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(yourNumber)+
                Util.getValueIfExist(paymentDate)+
                Util.getValueIfExist(coin)+
                Util.getValueIfExist(paymentValue)+
                Util.getValueIfExist(ourNumber)+
                Util.getValueIfExist(effectivePaymentDate)+
                Util.getValueIfExist(effectivePaymentAmount);
    }

    public BigDecimal getTotalOfCoin() {
        return this.coin.getTotalOfCoin();
    }

    public BigDecimal getPaymentAmount() {
        return this.paymentValue.getField();
    }

    public static final class PaymentBuilder {
        private CurrentCoin coin;
        private OurNumber ourNumber;
        private YourNumber yourNumber;
        private PaymentDate paymentDate;
        private PaymentValue paymentValue;
        private EffectivePaymentDate effectivePaymentDate;
        private EffectivePaymentAmount effectivePaymentAmount;

        public PaymentBuilder() {
        }

        public PaymentBuilder(YourNumber yourNumber, PaymentDate paymentDate, CurrentCoin coin,
                              PaymentValue paymentValue, OurNumber ourNumber, EffectivePaymentDate effectivePaymentDate,
                              EffectivePaymentAmount effectivePaymentAmount) {
            this.coin = coin;
            this.ourNumber = ourNumber;
            this.yourNumber = yourNumber;
            this.paymentDate = paymentDate;
            this.paymentValue = paymentValue;
            this.effectivePaymentDate = effectivePaymentDate;
            this.effectivePaymentAmount = effectivePaymentAmount;
        }

        public PaymentBuilder setYourNumber(YourNumber yourNumber) {
            this.yourNumber = yourNumber;
            return this;
        }

        public PaymentBuilder setPaymentDate(PaymentDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentBuilder setCoin(CurrentCoin coin) {
            this.coin = coin;
            return this;
        }

        public PaymentBuilder setPaymentValue(PaymentValue paymentValue) {
            this.paymentValue = paymentValue;
            return this;
        }

        public PaymentBuilder setOurNumber(OurNumber ourNumber) {
            this.ourNumber = ourNumber;
            return this;
        }

        public PaymentBuilder setEffectivePaymentDate(EffectivePaymentDate effectivePaymentDate) {
            this.effectivePaymentDate = effectivePaymentDate;
            return this;
        }

        public PaymentBuilder setEffectivePaymentAmount(EffectivePaymentAmount effectivePaymentAmount) {
            this.effectivePaymentAmount = effectivePaymentAmount;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
