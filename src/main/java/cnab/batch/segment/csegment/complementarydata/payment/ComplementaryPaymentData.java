package cnab.batch.segment.csegment.complementarydata.payment;

import cnab.utils.Util;

import java.math.BigDecimal;

public class ComplementaryPaymentData {
    private final IrValue irValue;
    private final IssValue issValue;
    private final IOFValue iofValue;
    private final OtherAdditions otherAdditions;
    private final OtherDeductions otherDeductions;

    public ComplementaryPaymentData(ComplementaryPaymentDataBuilder complementaryPaymentDataBuilder) {
        this.irValue = complementaryPaymentDataBuilder.irValue;
        this.issValue = complementaryPaymentDataBuilder.issValue;
        this.iofValue = complementaryPaymentDataBuilder.iofValue;
        this.otherAdditions = complementaryPaymentDataBuilder.otherAdditions;
        this.otherDeductions = complementaryPaymentDataBuilder.otherDeductions;
    }

    public static ComplementaryPaymentData createEmptyComplementaryData() {
        IrValue irValue = new IrValue(new BigDecimal("0"));
        IssValue issValue = new IssValue(new BigDecimal("0"));
        IOFValue iofValue = new IOFValue(new BigDecimal("0"));
        OtherDeductions otherDeductions = new OtherDeductions(new BigDecimal("0"));
        OtherAdditions otherAdditions = new OtherAdditions(new BigDecimal("0"));
        return new ComplementaryPaymentDataBuilder()
                .setIofValue(iofValue)
                .setIrValue(irValue)
                .setIssValue(issValue)
                .setOtherAdditions(otherAdditions)
                .setOtherDeductions(otherDeductions)
                .build();
    }

    @Override
    public String toString() {
        return  Util.getValueIfExist(irValue)+
                Util.getValueIfExist(issValue)+
                Util.getValueIfExist(iofValue)+
                Util.getValueIfExist(otherDeductions)+
                Util.getValueIfExist(otherAdditions);
    }

    public static final class ComplementaryPaymentDataBuilder {
        private IrValue irValue;
        private IssValue issValue;
        private IOFValue iofValue;
        private OtherAdditions otherAdditions;
        private OtherDeductions otherDeductions;

        public ComplementaryPaymentDataBuilder() {
        }

        public ComplementaryPaymentDataBuilder(IrValue irValue, IssValue issValue, IOFValue iofValue,
                                               OtherDeductions otherDeductions, OtherAdditions otherAdditions) {
            this.irValue = irValue;
            this.issValue = issValue;
            this.iofValue = iofValue;
            this.otherAdditions = otherAdditions;
            this.otherDeductions = otherDeductions;
        }

        public ComplementaryPaymentDataBuilder setIrValue(IrValue irValue) {
            this.irValue = irValue;
            return this;
        }

        public ComplementaryPaymentDataBuilder setIssValue(IssValue issValue) {
            this.issValue = issValue;
            return this;
        }

        public ComplementaryPaymentDataBuilder setIofValue(IOFValue iofValue) {
            this.iofValue = iofValue;
            return this;
        }

        public ComplementaryPaymentDataBuilder setOtherDeductions(OtherDeductions otherDeductions) {
            this.otherDeductions = otherDeductions;
            return this;
        }

        public ComplementaryPaymentDataBuilder setOtherAdditions(OtherAdditions otherAdditions) {
            this.otherAdditions = otherAdditions;
            return this;
        }

        public ComplementaryPaymentData build(){
            return new ComplementaryPaymentData(this);
        }
    }
}
